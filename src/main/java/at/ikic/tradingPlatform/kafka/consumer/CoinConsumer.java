package at.ikic.tradingPlatform.kafka.consumer;

import at.ikic.tradingPlatform.config.KafkaConstant;
import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Service
public class CoinConsumer {

    @Autowired
    private  CoinRepository coinRepository;

    @KafkaListener(topics = KafkaConstant.CRYPTO_COIN_TOPIC, groupId = KafkaConstant.CRYPTO_GROUP)
    public void consume(List<Coin> coins)
    {
        coinRepository.saveAll(coins);
    }


}
