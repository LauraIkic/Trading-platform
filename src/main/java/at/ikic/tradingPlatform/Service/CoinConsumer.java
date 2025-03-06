package at.ikic.tradingPlatform.Service;

import at.ikic.tradingPlatform.Entity.Coin;
import at.ikic.tradingPlatform.Repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Service
public class CoinConsumer {

    @Autowired
    private  CoinRepository coinRepository;

    @KafkaListener(topics = "cryptoCoinTopic", groupId = "cryptoGroup")
    public void consume(List<Coin> coins) {
        coinRepository.saveAll(coins);
    }


}
