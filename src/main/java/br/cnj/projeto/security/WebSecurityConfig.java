package br.cnj.projeto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	 auth.inMemoryAuthentication()
	 .withUser("rafael").roles("USER").password("{noop}123")
	 .and()
	 .withUser("admin").roles("ADMIN").password("{noop}123");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		

	 return http.authorizeHttpRequests(request -> request.
	requestMatchers(PathPatternRequestMatcher.pathPattern("/api/casos/**"))
	 .hasRole("USER"))
	 .authorizeHttpRequests(request -> request.requestMatchers(
			 PathPatternRequestMatcher.pathPattern("/api/arquivos/**"))
	 .hasRole("ADMIN")
	 .anyRequest()
	 .authenticated())
	 .httpBasic(Customizer.withDefaults())
	 .csrf((csrf) -> csrf.disable())
	 .build();
	}
}