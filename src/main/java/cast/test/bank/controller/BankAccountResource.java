package cast.test.bank.controller;

import cast.test.bank.model.BankAccount;
import cast.test.bank.model.Deposit;
import cast.test.bank.model.Transfer;
import cast.test.bank.model.Withdraw;
import cast.test.bank.service.BankAccountService;
import cast.test.bank.service.DepositService;
import cast.test.bank.service.TransferService;
import cast.test.bank.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
@CrossOrigin(origins = "http://localhost:4200")
public class BankAccountResource {
    private final BankAccountService bankAccountService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;

    @Autowired
    public BankAccountResource(BankAccountService bankAccountService, DepositService depositService, WithdrawService withdrawService, TransferService transferService) {
        this.bankAccountService = bankAccountService;
        this.depositService = depositService;
        this.withdrawService = withdrawService;
        this.transferService = transferService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountService.findAllBankAccount();
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }

    @GetMapping("/find/{cpf}")
    public ResponseEntity<BankAccount> getBankAccountByCpf(@PathVariable("cpf") String cpf) {
        BankAccount bankAccount = bankAccountService.findBankAccountByCpf(cpf);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BankAccount> addBankAccount (@RequestBody BankAccount bankAccount) {
        BankAccount newBankAccount = bankAccountService.addBankAccount(bankAccount);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BankAccount> updateBankAccount (@RequestBody BankAccount bankAccount) {
        BankAccount updateBankAccount = bankAccountService.updateBankAccount(bankAccount);
        return new ResponseEntity<>(updateBankAccount, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cpf}")
    public ResponseEntity<?> deleteBankAccountByCpf(@PathVariable("cpf") String cpf) {
        bankAccountService.deleteBankAccountByCpf(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public ResponseEntity<BankAccount> makeDeposit (@RequestBody Deposit deposit) {
        BankAccount bankAccount = bankAccountService.makeDeposit(deposit);
        depositService.addDeposit(deposit);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/withdraw")
    public ResponseEntity<BankAccount> makeWithdraw (@RequestBody Withdraw withdraw) {
        BankAccount bankAccount = bankAccountService.makeWithdraw(withdraw);
        withdrawService.addWithdraw(withdraw);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public ResponseEntity<List<BankAccount>> makeTransfer (@RequestBody Transfer transfer) {
        List<BankAccount> bankAccounts = bankAccountService.makeTransfer(transfer);
        transferService.addTransfer(transfer);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }

    @GetMapping("/deposit/all")
    public ResponseEntity<List<Deposit>> getAllDeposits() {
        List<Deposit> deposits = depositService.findAllDeposit();
        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }

    @GetMapping("/withdraw/all")
    public ResponseEntity<List<Withdraw>> getAllWithdraw() {
        List<Withdraw> withdraws = withdrawService.findAllWithdraw();
        return new ResponseEntity<>(withdraws, HttpStatus.OK);
    }

    @GetMapping("/transfer/all")
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        List<Transfer> transfers = transferService.findAllTransfer();
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }
}
