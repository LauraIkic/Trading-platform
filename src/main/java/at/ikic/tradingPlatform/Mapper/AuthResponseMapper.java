package at.ikic.tradingPlatform.Mapper;

import at.ikic.tradingPlatform.Dto.Response.AuthResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AuthResponseMapper {

    public AuthResponseDto toAuthResponseDto(String jwt, String message) {
        AuthResponseDto responseDto = new AuthResponseDto();
        responseDto.setJwt(jwt);
        responseDto.setStatus(true);
        responseDto.setMessage(message);
        responseDto.setIsTwoFactorAuthEnabled(false);
        responseDto.setSession(null);
        return responseDto;
    }
}
