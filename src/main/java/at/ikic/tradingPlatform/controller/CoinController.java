package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    @GetMapping("/coin")
    public List<Coin> list (){
       return coinRepository.findAll();
    }

    @GetMapping("/coin/{id}")
    public Optional<Coin> read (@PathVariable String id){
        return coinRepository.findById(id);
    }
}
