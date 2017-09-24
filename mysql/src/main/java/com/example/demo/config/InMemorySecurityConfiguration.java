package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

/**
 * Created by maxmamuta on 9/16/17.
 */
//@Configuration
//@EnableGlobalAuthentication
public class InMemorySecurityConfiguration {

/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password")
                .roles("USER")
                .and().withUser("admin").password("password")
                .roles("USER","ADMIN");
    } */
}
