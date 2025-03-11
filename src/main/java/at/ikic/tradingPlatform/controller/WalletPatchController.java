package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.enums.WalletTransactionType;
import at.ikic.tradingPlatform.dto.request.WalletRequestDto;
import at.ikic.tradingPlatform.entity.Wallet;
import at.ikic.tradingPlatform.repository.WalletRepository;
import at.ikic.tradingPlatform.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WalletPatchController {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private AuthService authService;

    @PatchMapping("/wallet")
    public ResponseEntity<Wallet> patch (@PathVariable UUID id, @RequestBody WalletRequestDto data){
        Wallet wallet = authService.getAuthenticatedUser().getWallet();

        BigDecimal newBalance;
        if ((data.getType() == WalletTransactionType.DEPOSIT)) {
            newBalance = wallet.getBalance().add(BigDecimal.valueOf(data.getAmount()));
        } else {
            newBalance = wallet.getBalance().subtract(BigDecimal.valueOf(data.getAmount()));
        }

        wallet.setBalance(newBalance);

        walletRepository.save(wallet);

        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/wallet")
    public ResponseEntity<Wallet> read (){
        Wallet wallet = authService.getAuthenticatedUser().getWallet();

        return ResponseEntity.ok(wallet);
    }
}
