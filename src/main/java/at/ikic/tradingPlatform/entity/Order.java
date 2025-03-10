package at.ikic.tradingPlatform.entity;

import at.ikic.tradingPlatform.enums.TransactionStatus;
import at.ikic.tradingPlatform.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * TODO: Fix Security issue
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coin_id")
    private Coin coin;

    private TransactionType type;

    private int quantity;

    private double price;

    private TransactionStatus status;

    private Instant date;
}
