package cast.test.bank.repo;

import cast.test.bank.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransferRepo extends JpaRepository<Transfer, Long> {
    Optional<Transfer> findTransferById(Long id);
}
