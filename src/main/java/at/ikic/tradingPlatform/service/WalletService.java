package at.ikic.tradingPlatform.service;

import at.ikic.tradingPlatform.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    @Autowired
    private AuthService authService;

   public void depositMoney(BigDecimal money) {
       Wallet wallet = authService.getAuthenticatedUser().getWallet();
       wallet.setBalance(wallet.getBalance().subtract(money));
   }

   public void withdrawMoney(BigDecimal money){
       Wallet wallet = authService.getAuthenticatedUser().getWallet();
       wallet.setBalance(wallet.getBalance().add(money));
   }

   public Boolean balanceSufficient(BigDecimal money) {
       Wallet wallet = authService.getAuthenticatedUser().getWallet();

       return wallet.getBalance().compareTo(money) >= 0;
   }
}
