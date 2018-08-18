package com.greenfield.servicetogo;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.greenfield.servicetogo.car.service.CustomUserDetailsService;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SevicetogoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
       // http.authorizeRequests()
         //       .antMatchers("**/secured/**").authenticated()
          //      .anyRequest().permitAll()
           //     .and()
           //    .formLogin().permitAll(); 
                
		
		//http.httpBasic();
		http.authorizeRequests()
			.antMatchers("/","/**/*.js","/**/*.html","/**/*.css","/**/*.js.map",
				 "/**/*.jpg","/**/*.png","/**/font*","/**/*.ico").permitAll()
		//	.anyRequest().permitAll();
		.anyRequest().authenticated()
		.and()
        //.formLogin().loginPage("/login").permitAll(); 
        .formLogin().successHandler(successHandler()).permitAll(); 
        // .formLogin().permitAll();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new SimpleAuthenticationSuccessHandler();
	}
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		auth.inMemoryAuthentication()
		.withUser("ranjana").password("{noop}ranjana123").roles("CUSTOMER").and()
		.withUser("anjana").password("{noop}anjana123").roles("ADMIN");
		 */
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	   
	  }

	private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
            	System.out.println("charSequence:"+ charSequence.toString());
            	System.out.println("s:"+ s);
                return charSequence.toString().equals(s);
            }
        };
    }


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}


class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication authentication)
			 {
		
		try {
			redirectStrategy.sendRedirect(arg0, arg1, "/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
 
}
