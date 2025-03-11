package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    @GetMapping("/coin")
    public ResponseEntity<List<Coin>> list (){
        return ResponseEntity.ok(coinRepository.findAll());
    }

    @GetMapping("/coin/{id}")
    public ResponseEntity<Optional<Coin>> read (@PathVariable String id){
        return ResponseEntity.ok(coinRepository.findById(id));
    }
}
