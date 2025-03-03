package at.ikic.tradingPlatform.Controller;

import at.ikic.tradingPlatform.Dto.Request.AuthRequestDto;
import at.ikic.tradingPlatform.Entity.User;
import at.ikic.tradingPlatform.Mapper.AuthResponseMapper;
import at.ikic.tradingPlatform.Repository.UserRepository;
import at.ikic.tradingPlatform.Dto.Response.AuthResponseDto;
import at.ikic.tradingPlatform.Service.AuthService;
import at.ikic.tradingPlatform.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  AuthService authService;
    @Autowired
    private  AuthResponseMapper authResponseMapper;

    @PostMapping("/signup")
    public AuthResponseDto register (@RequestBody User user) throws Exception {
        if (null != userRepository.findByMail(user.getMail())) {
            throw new Exception("This mail is already in use.");
        }
        userRepository.save(user);
        authService.authenticateNewUser(user);

        return authResponseMapper.toAuthResponseDto(JwtTokenProvider.generateToken(), "User registered successfully.");
    }

    @PostMapping("/login")
    public AuthResponseDto login (@RequestBody AuthRequestDto data) {
        Authentication auth = authService.authenticateUser(data);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return authResponseMapper.toAuthResponseDto(JwtTokenProvider.generateToken(), "User logged in successfully.");
    }
}
