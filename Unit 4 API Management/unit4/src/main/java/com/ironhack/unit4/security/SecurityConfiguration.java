package com.ironhack.unit4.security;

import com.ironhack.unit4.service.implementations.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder);

/*                auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("123456"))
                .roles("ADMIN", "USER")
                .and()
                .withUser("user").password(passwordEncoder.encode("123456"))
                .roles("USER");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.httpBasic();
       http.csrf().disable();
       http.authorizeRequests()
               .mvcMatchers(HttpMethod.GET, "/hello-world").authenticated()
               .mvcMatchers(HttpMethod.GET, "/hello-me").authenticated()
               .mvcMatchers(HttpMethod.GET, "/hello-world/**").hasRole("ADMIN")
               .mvcMatchers(HttpMethod.POST, "/hello-world").hasAnyRole("ADMIN", "TECHNICIAN")
               .anyRequest().permitAll();
    }
}
