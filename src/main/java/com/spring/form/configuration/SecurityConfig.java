package com.spring.form.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF if not needed
            .authorizeRequests()
            .antMatchers("/savings").permitAll() // Assuming '/register' is your registration endpoint
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/register")  // Your custom login page URL
                .loginProcessingUrl("/register")  // URL on which the clients should post the login information
                .defaultSuccessUrl("/home", true)  // After successful authentication, user will be redirected to this page
                .failureUrl("/custom-login?error=true")  // In case of a failed login attempt, redirect back to custom login page with an error flag
            .permitAll();  // Allow access to any user to the custom login page
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
