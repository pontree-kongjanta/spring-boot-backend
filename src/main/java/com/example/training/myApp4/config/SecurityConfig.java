package com.example.training.myApp4.config;

import com.example.training.myApp4.config.token.TokenFilter;
import com.example.training.myApp4.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class SecurityConfig {

    private final TokenService tokenService;

    public SecurityConfig(TokenService tokenService){
        this.tokenService = tokenService;
    }

    private final String[] PUBLIC = {
            "/actuator/**"
            ,"/myApp/register"
            ,"/myApp/login"
            ,"/myApp/updateUser"
            ,"/socket/**"
            //,"/chat/message"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((request)->request
                        .requestMatchers(PUBLIC).permitAll()
                        .anyRequest().authenticated())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .addFilterBefore(new TokenFilter(tokenService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
