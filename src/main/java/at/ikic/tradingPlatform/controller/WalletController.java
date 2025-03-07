package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.Enum.WalletTransactionType;
import at.ikic.tradingPlatform.dto.request.WalletRequestDto;
import at.ikic.tradingPlatform.entity.Wallet;
import at.ikic.tradingPlatform.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @PatchMapping("/wallet/{id}")
    public ResponseEntity<Wallet> patch (@PathVariable UUID id, @RequestBody WalletRequestDto data){
        Wallet wallet = walletRepository.findById(id).orElse(null);

        BigDecimal newBalance;
        assert wallet != null;
        if ((data.getType() == WalletTransactionType.ADD)) {
            newBalance = wallet.getBalance().add(BigDecimal.valueOf(data.getAmount()));
        } else {
            newBalance = wallet.getBalance().subtract(BigDecimal.valueOf(data.getAmount()));
        }

        wallet.setBalance(newBalance);

        walletRepository.save(wallet);

        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/wallet/{id}")
    public ResponseEntity<Wallet> read (@PathVariable UUID id){
        Wallet wallet = walletRepository.findById(id).orElse(null);

        assert wallet != null;
        return ResponseEntity.ok(wallet);
    }
}
