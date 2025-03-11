package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.entity.Portfolio;
import at.ikic.tradingPlatform.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PortfolioReadController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping("/portfolio/{id}")
    public Optional<Portfolio> read (@PathVariable String id){
        return portfolioRepository.findById(UUID.fromString(id));
    }
}
