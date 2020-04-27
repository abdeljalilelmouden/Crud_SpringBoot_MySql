package org.sid.stagiaire.securite;

 
import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecuriteConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth,javax.sql.DataSource dataSource) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncoder();
		 auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
		 auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("USER");
		 auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER", "ADMIN");
		 
		/*
		 * auth.jdbcAuthentication() .dataSource(dataSource)
		 * .usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?"
		 * )
		 * .authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_role where user_username = ?"
		 * ). rolePrefix("ROLE_");
		 */
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/index.html");
		 http.formLogin();
		 // http.authorizeRequests().anyRequest().authenticated();
		 http.authorizeRequests().antMatchers("/save**/**", "/delete**/**", "/form**/**").hasRole("ADMIN");
		 http.authorizeRequests().anyRequest().authenticated();
		 http.exceptionHandling().accessDeniedPage("/403");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
