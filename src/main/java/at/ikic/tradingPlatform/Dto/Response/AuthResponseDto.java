package at.ikic.tradingPlatform.Dto.Response;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String jwt;
    private Boolean status;
    private String message;
    private Boolean isTwoFactorAuthEnabled;
    private String session;
}
