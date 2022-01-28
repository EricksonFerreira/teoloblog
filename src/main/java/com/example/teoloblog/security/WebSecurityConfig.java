package com.example.teoloblog.security;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.h2.server.web.WebServlet;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable()
                .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(SWAGGER_WHITELIST).permitAll()
                .antMatchers("/h2-console/**").permitAll()
                // login
                .antMatchers("/api/login").permitAll()
                // autor
                .antMatchers("/api/autor").permitAll()
                .antMatchers(HttpMethod.GET,"/api/autor/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/autor/").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.PUT,"/api/autor/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.DELETE,"/api/autor/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                // comentario
                .antMatchers("/api/comentario").permitAll()
                .antMatchers(HttpMethod.GET,"/api/comentario/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/comentario/").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.PUT,"/api/comentario/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.DELETE,"/api/comentario/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                // etiqueta
                .antMatchers("/api/etiqueta").permitAll()
                .antMatchers(HttpMethod.GET,"/api/etiqueta/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/etiqueta/").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.PUT,"/api/etiqueta/{id}").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.DELETE,"/api/etiqueta/{id}").hasAnyRole("ADMINISTRADOR","GERENTE")
                // funcao
                .antMatchers("/api/funcao").permitAll()
                .antMatchers(HttpMethod.GET,"/api/funcao/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/funcao/").hasAnyRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.PUT,"/api/funcao/{id}").hasAnyRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/api/funcao/{id}").hasAnyRole("ADMINISTRADOR")
                // publicacao
                .antMatchers("/api/publicacao").permitAll()
                .antMatchers(HttpMethod.GET,"/api/publicacao/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/publicacao/").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.PUT,"/api/publicacao/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.DELETE,"/api/publicacao/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                // referencia
                .antMatchers("/api/referencia").permitAll()
                .antMatchers(HttpMethod.GET,"/api/referencia/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/referencia/").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.PUT,"/api/referencia/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                .antMatchers(HttpMethod.DELETE,"/api/referencia/{id}").hasAnyRole("ADMINISTRADOR","GERENTE","NORMAL")
                // usuario
                .antMatchers("/api/usuario").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.GET,"/api/usuario/{id}").hasAnyRole("ADMINISTRADOR","GERENTE")
                .antMatchers(HttpMethod.POST,"/api/usuario/").hasAnyRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.PUT,"/api/usuario/{id}").hasAnyRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE,"/api/usuario/{id}").hasAnyRole("ADMINISTRADOR")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    @Bean //HABILITANDO ACESSAR O H2-DATABSE NA WEB
    public ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }
}
