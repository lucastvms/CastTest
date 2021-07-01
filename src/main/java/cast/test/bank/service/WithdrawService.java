package cast.test.bank.service;

import cast.test.bank.exception.CustomNotFoundException;
import cast.test.bank.model.Withdraw;
import cast.test.bank.repo.WithdrawRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawService {
    private final WithdrawRepo withdrawRepo;

    @Autowired
    public WithdrawService(WithdrawRepo withdrawRepo) {
        this.withdrawRepo = withdrawRepo;
    }

    public Withdraw addWithdraw(Withdraw withdraw) {
        return this.withdrawRepo.save(withdraw);
    }

    public List<Withdraw> findAllWithdraw() {
        return withdrawRepo.findAll();
    }

    public Withdraw findWithdrawById(Long id) {
        return withdrawRepo.findWithdrawById(id)
                .orElseThrow(() -> new CustomNotFoundException("Withdraw by id " + id + "was not found"));
    }
}
