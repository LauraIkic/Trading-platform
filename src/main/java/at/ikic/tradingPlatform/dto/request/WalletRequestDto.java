package at.ikic.tradingPlatform.dto.request;

import at.ikic.tradingPlatform.enums.WalletTransactionType;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class WalletRequestDto {

    @NotNull(message = "Amount cannot be null")
    private Long amount;

    @NotNull(message = "Type cannot be null")
    private WalletTransactionType type;
}
