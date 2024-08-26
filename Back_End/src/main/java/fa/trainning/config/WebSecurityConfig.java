package fa.trainning.config;

import fa.trainning.config.filters.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private String[] swaggerAntPatterns = { "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
			"/configuration/security", "/swagger-ui.html", "/webjars/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(swaggerAntPatterns);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				//every user role can login and register
				.antMatchers("/user/login", "/user/register","/user-permission/*").permitAll()

				 //super_admin can manage user permission
//                .antMatchers("/user-permission/get-all", "/user-permission/update-permission")
//                .access("hasAuthority('ROLE:SUPER_ADMIN')")
//
//                //super_admin, class_admin have full access including view, create, modify can access list of users
//                .antMatchers("/user")
//                .access("hasAnyAuthority('ROLE:SUPER_ADMIN', 'ROLE:CLASS_ADMIN') "
//                		+ "and !hasAuthority('USER_MANAGEMENT:ACCESS_DENIED')")
//
//                //super_admin, class_admin has full access or modify can update a user
//                .antMatchers("/user/update-password", "/user/update-user", "/user/update-role")
//                .access("hasAnyAuthority('ROLE:SUPER_ADMIN', 'ROLE:CLASS_ADMIN', "
//                		+ "'USER_MANAGEMENT:MODIFY', 'USER_MANAGEMENT:FULL_ACCESS')")
//
//                //super_admin, class_admin, trainer can create a syllabus
//                .antMatchers("/syllabus/create-syllabus", "/syllabus/create-syllabus-draft", "/syllabus/search/{letter}")
//                .access("hasAnyAuthority('ROLE:SUPER_ADMIN', 'ROLE:CLASS_ADMIN', 'ROLE:TRAINER', "
//                		+ "'SYLLABUS:CREATE', 'SYLLABUS:FULL_ACCESS')")
//
//                //trainer has permission to duplicate a syllabus
//                .antMatchers("/syllabus/duplicate/{topicCode}")
//                .access("hasAnyAuthority('ROLE:TRAINER', "
//                		+ "'SYLLABUS:CREATE', 'SYLLABUS:MODIFY', 'SYLLABUS:FULL_ACCESS')")

				//JWT Filter
				.and()
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
