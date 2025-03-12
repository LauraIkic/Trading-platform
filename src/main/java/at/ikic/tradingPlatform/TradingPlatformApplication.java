package at.ikic.tradingPlatform;

import at.ikic.tradingPlatform.entity.Marketplace;
import at.ikic.tradingPlatform.service.MarketPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class TradingPlatformApplication implements CommandLineRunner {

	@Autowired
	private MarketPlaceService marketplaceService;

	public static void main(String[] args) {
		SpringApplication.run(TradingPlatformApplication.class, args
		);
	}

	@Override
	public void run(String... args) throws Exception {
		marketplaceService.getOrCreateMarketplace();
	}
}
