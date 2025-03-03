package at.ikic.tradingPlatform.Entity;

import at.ikic.tradingPlatform.Enum.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;

    private VerificationType verificationType;
}
