package com.demo.config;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //LDAP or Database
    //In Memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Value("${login.username}")
    private String username;

    @Value("${login.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = createNewUser(username, password);

        return new InMemoryUserDetailsManager(userDetails);
    }

    private UserDetails createNewUser(String username, String password) {
        UnaryOperator<String> passwordEncoder = input -> passwordEncoder().encode(input);

        return User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //All URLs are protected
    //A login form is shown for unauthorized requests
    //CSRF disable
    //Frames
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.httpBasic(withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }

}

