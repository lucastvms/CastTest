package cast.test.bank.controller;

import cast.test.bank.model.BankAccount;
import cast.test.bank.model.Deposit;
import cast.test.bank.model.Transfer;
import cast.test.bank.model.Withdraw;
import cast.test.bank.service.BankAccountService;
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

    @Autowired
    public BankAccountResource(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
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
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/withdraw")
    public ResponseEntity<BankAccount> makeWithdraw (@RequestBody Withdraw withdraw) {
        BankAccount bankAccount = bankAccountService.makeWithdraw(withdraw);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public ResponseEntity<List<BankAccount>> makeTransfer (@RequestBody Transfer transfer) {
        List<BankAccount> bankAccounts = bankAccountService.makeTransfer(transfer);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }
}
