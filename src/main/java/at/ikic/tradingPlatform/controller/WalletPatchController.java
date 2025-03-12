package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.enums.WalletTransactionType;
import at.ikic.tradingPlatform.dto.request.WalletRequestDto;
import at.ikic.tradingPlatform.entity.Wallet;
import at.ikic.tradingPlatform.repository.WalletRepository;
import at.ikic.tradingPlatform.service.AuthService;
import at.ikic.tradingPlatform.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WalletPatchController {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private AuthService authService;

    @PatchMapping("/wallet")
    public ResponseEntity<Wallet> patch (@RequestBody WalletRequestDto data){
        Wallet wallet = authService.getAuthenticatedUser().getWallet();

        if ((data.getType() == WalletTransactionType.DEPOSIT)) {
            walletService.depositMoney(data.getAmount());
        } else {
            walletService.withdrawMoney(data.getAmount());
        }

        walletRepository.save(wallet);

        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/wallet")
    public ResponseEntity<Wallet> read (){
        Wallet wallet = authService.getAuthenticatedUser().getWallet();

        return ResponseEntity.ok(wallet);
    }
}
