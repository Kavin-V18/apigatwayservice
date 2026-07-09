package com.example.api_gateway.config;

import com.example.api_gateway.filter.JwtAuthFilter;
import com.example.api_gateway.filter.JwtCookieFilter;
import com.example.api_gateway.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthFilter authFilter;
    private final JwtCookieFilter jwtCookieFilter;
    private final CustomUserDetailsService userDetailsService;
    public SecurityConfig(JwtAuthFilter authFilter, CustomUserDetailsService userDetailsService,JwtCookieFilter jwtCookieFilter) {
        this.authFilter = authFilter;
        this.userDetailsService = userDetailsService;
        this.jwtCookieFilter=jwtCookieFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**", "/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**"
                        ).permitAll()
                        .requestMatchers("/api/users/**", "/api/auditlog/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders/**", "/api/qualityinspection/**", "/api/vehicledelivery/**", "/api/servicehistory/**").hasAnyRole("ADMIN", "PLANT_MANAGER")
                        .requestMatchers("/api/vehicleinventory/**", "/api/carmodel/**").hasAnyRole("ADMIN", "PLANT_MANAGER", "SUPERVISOR")
                        .requestMatchers(HttpMethod.GET, "/api/suppliers/**", "/api/employee/**").hasAnyRole("ADMIN", "PLANT_MANAGER", "SUPERVISOR")
                        .requestMatchers("/api/suppliers/**", "/api/employee/**").hasRole("ADMIN")
                        .requestMatchers("/api/customer/**").hasAnyRole("ADMIN", "PLANT_MANAGER")
                        .requestMatchers("/api/notification/**").hasAnyRole("ADMIN", "PLANT_MANAGER", "SUPERVISOR")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtCookieFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
