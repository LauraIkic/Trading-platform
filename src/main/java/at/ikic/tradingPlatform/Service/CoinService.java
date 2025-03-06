package at.ikic.tradingPlatform.Service;

import at.ikic.tradingPlatform.Entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CoinService {
    private static final String TOPIC = "cryptoCoinTopic";
    private static final String COIN_GECKO_API_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";
    @Autowired
    private KafkaTemplate<String, List<Coin>> kafkaTemplate;

    @Scheduled(fixedRate = 60000)
    public void fetchCoinData() {
        RestTemplate restTemplate = new RestTemplate();
        List<Coin> coins = restTemplate.getForObject(COIN_GECKO_API_URL, List.class);

        if (coins != null) {
            kafkaTemplate.send(TOPIC, coins);
        }
    }
}
