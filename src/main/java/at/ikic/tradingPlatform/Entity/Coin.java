package at.ikic.tradingPlatform.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String image;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "market_cap")
    private long marketCap;

    @Column(name = "market_cap_rank")
    private int marketCapRank;

    @Column(name = "fully_diluted_valuation")
    private long fullyDilutedValuation;

    @Column(name = "total_volume")
    private long totalVolume;

    @Column(name = "high_24h")
    private double high24h;

    @Column(name = "low_24h")
    private double low24h;

    @Column(name = "price_change_24h")
    private double priceChange24h;

    @Column(name = "price_change_percentage_24h")
    private double priceChangePercentage24h;

    @Column(name = "market_cap_change_24h")
    private long marketCapChange24h;

    @Column(name = "market_cap_change_percentage_24h")
    private double marketCapChangePercentage24h;

    @Column(name = "circulating_supply")
    private long circulatingSupply;

    @Column(name = "total_supply")
    private long totalSupply;

    @Column(name = "max_supply")
    private long maxSupply;

    @Column(name = "ath")
    private double ath;

    @Column(name = "ath_change_percentage")
    private double athChangePercentage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ath_date")
    private Date athDate;

    @Column(name = "atl")
    private double atl;

    @Column(name = "atl_change_percentage")
    private double atlChangePercentage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "atl_date")
    private Date atlDate;

    private Double roi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated")
    private Date lastUpdated;
}
