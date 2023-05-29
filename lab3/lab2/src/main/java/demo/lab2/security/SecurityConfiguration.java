package demo.lab2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("client")
                .password("{noop}client")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("worker")
                .password("{noop}worker")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/cars","/cars/dealership", "/cars/affordable",
                        "/cars/body-type", "/cars/taken", "/cars/take", "/cars/return").hasRole("USER")
        .requestMatchers("/cars/create", "/cars/update", "/cars/delete").hasRole("ADMIN")
        .and().httpBasic();
        http.csrf().disable();
        return http.build();
    }
}
