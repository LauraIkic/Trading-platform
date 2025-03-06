package at.ikic.tradingPlatform.Repository;


import at.ikic.tradingPlatform.Entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoinRepository extends JpaRepository <Coin, String>{

}
