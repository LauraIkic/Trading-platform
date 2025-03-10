package at.ikic.tradingPlatform.kafka.producer;

import at.ikic.tradingPlatform.constants.KafkaConstant;
import at.ikic.tradingPlatform.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinProducer {

    @Autowired
    private KafkaTemplate<String, List<Coin>> kafkaTemplate;

    public void sendCoinsToKafka(List<Coin> coins) {
        if (null != coins && !coins.isEmpty()) {
            kafkaTemplate.send(KafkaConstant.CRYPTO_COIN_TOPIC, coins);
        }
    }
}
