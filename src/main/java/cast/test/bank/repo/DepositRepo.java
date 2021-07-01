package cast.test.bank.repo;

import cast.test.bank.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepositRepo extends JpaRepository<Deposit, Long> {

    Optional<Deposit> findDepositById(Long id);
}



