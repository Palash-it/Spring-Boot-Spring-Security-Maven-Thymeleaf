package com.palash.investment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.palash.investment.repository.UserRepository;

/*
 * Spring boot + spring secutiry to login with role
 * Author : Palash Kumar Nath
 * Email : palash.debnath5@gmail.com
 */
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/users/**").hasAnyRole("admin","user","superAdmin")
				.antMatchers("/admin/**").hasAnyRole("admin","superAdmin")
				.anyRequest().authenticated()
			.and()
				.csrf().disable()
				.formLogin()
				.loginPage("/auth/login")
				.failureUrl("/auth/login?status=error")
				.defaultSuccessUrl("/users/dashboard",true)
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
				.logoutSuccessUrl("/auth/login").and().exceptionHandling()
				.accessDeniedPage("/auth/access-denied")
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
				.sessionFixation().migrateSession()
				.invalidSessionUrl("/auth/session-invalid")
				.maximumSessions(1)
				.expiredUrl("/auth/session-expired");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/static/**");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
		daoAuth.setUserDetailsService(this.userDetailsService);
		daoAuth.setHideUserNotFoundExceptions(false);
		daoAuth.setPasswordEncoder(passwordEncoder());
		return daoAuth;
	}
	
	
}
