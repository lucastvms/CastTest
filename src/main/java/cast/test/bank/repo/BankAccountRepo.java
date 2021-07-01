package cast.test.bank.repo;

import cast.test.bank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepo extends JpaRepository<BankAccount, String> {


    void deleteBankAccountByCpf(String cpf);

    Optional<BankAccount> findBankAccountByCpf(String cpf);
}
