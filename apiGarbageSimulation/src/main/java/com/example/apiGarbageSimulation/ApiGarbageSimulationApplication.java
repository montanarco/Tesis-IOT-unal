package com.example.apiGarbageSimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class ApiGarbageSimulationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ApiGarbageSimulationApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				//.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/auth").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/auth").permitAll()
				.antMatchers(HttpMethod.GET, "/api/containers/generateLevels/*").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/containers/generateLevels/*").permitAll()
				.antMatchers(HttpMethod.GET, "/api/dailyOperation/fetchDailyOperation/*").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/dailyOperation/fetchDailyOperation/*").permitAll()
				.antMatchers(HttpMethod.GET, "/api/dailyOperation/createDailyOperation/*").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/dailyOperation/createDailyOperation/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/cluster/streets/*").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/cluster/streets/*").permitAll()
				.antMatchers(HttpMethod.GET, "/api/containers/fetchLastMeasures/").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/containers/fetchLastMeasures/").permitAll()
				.anyRequest().authenticated();
		}
	}

}
