package at.ikic.tradingPlatform.entity;

import at.ikic.tradingPlatform.Enum.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false;

    private VerificationType verificationType;
}
