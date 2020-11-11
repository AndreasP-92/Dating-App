//package com.example.datingApp.DatingApp.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//class SecurityConfiguration02 extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        Authorize Requests
//        http.authorizeRequests()
////                Tilladelse på route kun hvis bruger har admin rolle
//                .antMatchers("/admin").hasRole("ADMIN")
////                <-> admin eller bruger rolle
//                .antMatchers("/user").hasAnyRole("ADMIN","USER")
////                Tillad alle
//                .antMatchers("/").permitAll()
////                Tillader form login
//                .and().formLogin();
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return super.userDetailsService();
////    }
//}
