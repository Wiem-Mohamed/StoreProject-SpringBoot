package com.wiem.store.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Wiem Mohamed
 */
@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {

    private static final String[] UN_SECURED_URLs = {"/users/**"};

    private static final String[] SECURED_URLs_ADMIN = {
            "/products/**",
            "/categories/**",
            "/Oorders/list"
    };
    private static final String[] SECURED_URLs_USER = {
            "/products/list",
            "/categories/list",
            "/Oorders/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new LibraryUserDetailsService();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UN_SECURED_URLs).permitAll().and()
                .authorizeHttpRequests().requestMatchers(SECURED_URLs_ADMIN)
                .hasAuthority("ADMIN")
                .and()
                .authorizeHttpRequests().requestMatchers(SECURED_URLs_USER)
                .hasAuthority("USER").anyRequest()
                .authenticated().and().httpBasic().and().build();

    }

}



