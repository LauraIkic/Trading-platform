package at.ikic.tradingPlatform.dto.Request;

import at.ikic.tradingPlatform.Enum.WalletTransactionType;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class WalletRequestDto {

    @NotNull(message = "Amount cannot be null")
    private Long amount;

    @NotNull(message = "Type cannot be null")
    private WalletTransactionType type;
}
