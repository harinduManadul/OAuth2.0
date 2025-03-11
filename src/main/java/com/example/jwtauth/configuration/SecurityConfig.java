package com.example.jwtauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import com.example.jwtauth.comoponents.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
    public SecurityConfig(CustomAuthenticationEntryPoint customAuthentication) {}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/users/login").permitAll()
                    .requestMatchers("/api/users/register").permitAll()
                    .requestMatchers("/api/users/request01").hasRole("USER")
                    .requestMatchers("/api/users/request02").hasRole("ADMIN")
                    .requestMatchers("/api/users/request03").hasAnyRole("USER", "ADMIN")
                    .anyRequest().authenticated()
            )
    //        .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
