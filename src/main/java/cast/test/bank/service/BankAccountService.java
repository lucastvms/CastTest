package cast.test.bank.service;

import cast.test.bank.exception.CustomNotFoundException;
import cast.test.bank.model.BankAccount;
import cast.test.bank.model.Deposit;
import cast.test.bank.model.Transfer;
import cast.test.bank.model.Withdraw;
import cast.test.bank.repo.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BankAccountService {
    private final BankAccountRepo bankAccountRepo;

    @Autowired
    public BankAccountService(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepo.save(bankAccount);
    }

    public List<BankAccount> findAllBankAccount() {
        return bankAccountRepo.findAll();
    }

    public void deleteBankAccountByCpf(String cpf) {
        bankAccountRepo.deleteBankAccountByCpf(cpf);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepo.save(bankAccount);
    }

    public BankAccount findBankAccountByCpf(String cpf) {
        return bankAccountRepo.findBankAccountByCpf(cpf)
                .orElseThrow(() -> new CustomNotFoundException("Account by cpf " + cpf + "was not found"));
    }

    public BankAccount makeDeposit(Deposit deposit) {
        BankAccount bankAccount = findBankAccountByCpf(deposit.getCpf());
        bankAccount.setBalance(bankAccount.getBalance() + deposit.getValue());

        return bankAccountRepo.save(bankAccount);
    }

    public BankAccount makeWithdraw(Withdraw withdraw) {
        BankAccount bankAccount = findBankAccountByCpf(withdraw.getCpf());
        bankAccount.setBalance(bankAccount.getBalance() - withdraw.getValue());

        return bankAccountRepo.save(bankAccount);
    }

    public List<BankAccount> makeTransfer(Transfer transfer) {
        BankAccount bankAccountReceiver = findBankAccountByCpf(transfer.getCpfReceiver());
        BankAccount bankAccountSender = findBankAccountByCpf(transfer.getCpfSender());

        bankAccountReceiver.setBalance(bankAccountReceiver.getBalance() + transfer.getValue());
        bankAccountSender.setBalance(bankAccountSender.getBalance() - transfer.getValue());

        List<BankAccount> updatedBankAccounts = new ArrayList<BankAccount>();
        updatedBankAccounts.add(bankAccountRepo.save(bankAccountReceiver));
        updatedBankAccounts.add(bankAccountRepo.save(bankAccountSender));

        return updatedBankAccounts;
    }
}
