package cast.test.bank.controller;

import cast.test.bank.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepositResource {
    private final DepositService depositService;

    @Autowired
    public DepositResource(DepositService depositService) {
        this.depositService = depositService;
    }


}
