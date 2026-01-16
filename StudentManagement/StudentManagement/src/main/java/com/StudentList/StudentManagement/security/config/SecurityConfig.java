package com.StudentList.StudentManagement.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // PUBLIC (Feign + testing)
                .requestMatchers(HttpMethod.GET, "/api/students/public")
                .permitAll()

                // READ → TEACHER, AUTH
                .requestMatchers(HttpMethod.GET, "/api/students/**")
                .hasAnyRole("TEACHER", "AUTH")

                // CREATE / UPDATE → AUTH ONLY
                .requestMatchers(HttpMethod.POST, "/api/students/**")
                .hasRole("AUTH")

                .requestMatchers(HttpMethod.PATCH, "/api/students/**")
                .hasRole("AUTH")

                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
