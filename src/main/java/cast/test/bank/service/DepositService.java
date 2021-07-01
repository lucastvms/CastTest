package cast.test.bank.service;

import cast.test.bank.exception.CustomNotFoundException;
import cast.test.bank.model.BankAccount;
import cast.test.bank.model.Deposit;
import cast.test.bank.repo.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService {
    private final DepositRepo depositRepo;

    @Autowired
    public DepositService(DepositRepo depositRepo) {
        this.depositRepo = depositRepo;
    }

    public Deposit addDeposit(Deposit deposit) {
        return depositRepo.save(deposit);
    }

    public List<Deposit> findAllDeposit() {
        return depositRepo.findAll();
    }

    public Deposit findDepositById(Long id) {
        return depositRepo.findDepositById(id)
                .orElseThrow(() -> new CustomNotFoundException("Deposit by id " + id + "was not found"));
    }

}
