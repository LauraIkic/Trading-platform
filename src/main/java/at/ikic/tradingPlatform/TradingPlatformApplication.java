package at.ikic.tradingPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class TradingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingPlatformApplication.class, args
		);
	}

}
