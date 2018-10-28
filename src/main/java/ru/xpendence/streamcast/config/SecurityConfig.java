package ru.xpendence.streamcast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.xpendence.streamcast.util.PasswordUtils;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.10.18
 * Time: 15:23
 * e-mail: 2262288@gmail.com
 */
@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(PasswordUtils.encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();

//                .authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ADMIN')")
//                .and()
//                .formLogin()
////                .failureHandler()
//                .defaultSuccessUrl("/admin/users");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/admin");

    }
}
