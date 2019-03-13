package br.com.lf.sprint.secutiry;

import br.com.lf.sprint.service.LoginDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class AccessSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginDetailService loginDetailService;


    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //    http.authorizeRequests()
    //            .antMatchers("/*/user/**").hasRole("USER")
    //           .antMatchers("/*/admin/**").hasRole("ADMIN")
    //          .and()
    //         .httpBasic()
    //         .and()
    //         .csrf().disable();
    //}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, SecurityConstants.SIGN_UP_URL).permitAll()
                .antMatchers("/*/user/**").hasRole("USER")
                .antMatchers("/*/admin/**").hasRole("ADMIN")
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), loginDetailService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
