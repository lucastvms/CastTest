package cast.test.bank.service;

import cast.test.bank.exception.CustomNotFoundException;
import cast.test.bank.model.Transfer;
import cast.test.bank.repo.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    private final TransferRepo transferRepo;

    @Autowired
    public TransferService(TransferRepo transferRepo) {
        this.transferRepo = transferRepo;
    }

    public Transfer addTransfer(Transfer transfer) {
        return transferRepo.save(transfer);
    }

    public List<Transfer> findAllTransfer() {
        return transferRepo.findAll();
    }

    public Transfer findTransferById(Long id) {
        return transferRepo.findTransferById(id)
                .orElseThrow(() -> new CustomNotFoundException("Transfer by id " + id + "was not found"));
    }
}
