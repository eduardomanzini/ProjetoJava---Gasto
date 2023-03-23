package com.teste.resource;

import com.teste.configs.security.TokenServicee;
import com.teste.entidade.Usuario;
import com.teste.gastoDto.LoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;


    private TokenServicee tokenServicee;


    public AuthController(TokenServicee tokenServicee, AuthenticationManager authenticationManager) {
        this.tokenServicee = tokenServicee;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public String login (@RequestBody LoginDto login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        return tokenServicee.gerarToken(usuario);
    }


}
