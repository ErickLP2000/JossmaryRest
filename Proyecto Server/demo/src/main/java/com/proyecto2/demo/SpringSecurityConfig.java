package com.proyecto2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto2.demo.serviceImp.JwtTokenProvider;
import com.proyecto2.demo.serviceImp.UserService;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{

    @Autowired
    private UserService userService;

    @Autowired 
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/auth/**", "/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/**").authenticated()
            .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admi", true)
                .permitAll()
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true) // Invalidar la sesión
                .deleteCookies("JSESSIONID", "TuLlaveSecretaJWT") // Asegúrate de reemplazar "jwtToken" con el nombre de tu cookie JWT.
                .permitAll()
            .and().apply(new JwtConfigurer(jwtTokenProvider));
        
        return http.build();
    }

    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/**","/auth/**", "/css/**", "/js/**", "/images/**");
    }


    @Bean public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception { 
        return authConfig.getAuthenticationManager(); 
    }

    @Autowired 
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
        auth .inMemoryAuthentication() 
        .withUser("user").password(encriptarPassword().encode("password")).roles("USER") 
        .and() .withUser("admin").password(encriptarPassword().encode("admin")).roles("ADMIN"); 
    }
}