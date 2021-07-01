package cast.test.bank.repo;

import cast.test.bank.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WithdrawRepo extends JpaRepository<Withdraw, Long> {

    Optional<Withdraw> findWithdrawById(Long id);
}
