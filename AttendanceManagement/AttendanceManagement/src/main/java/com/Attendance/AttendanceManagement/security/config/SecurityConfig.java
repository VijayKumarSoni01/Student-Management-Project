package com.Attendance.AttendanceManagement.security.config;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(HttpMethod.GET, "/api/attendance/**")
                        .hasAnyRole("STUDENT", "TEACHER", "AUTH")

                        .requestMatchers(HttpMethod.POST, "/api/attendance/**")
                        .hasAnyRole("TEACHER", "AUTH")

                        .requestMatchers(HttpMethod.PATCH, "/api/attendance/**")
                        .hasAnyRole("TEACHER", "AUTH")

                        .requestMatchers(HttpMethod.DELETE, "/api/attendance/**")
                        .hasRole("AUTH")

                        .anyRequest().authenticated())
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
