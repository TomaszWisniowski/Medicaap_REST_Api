package pl.medicaap.tomaszwisniowski.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pl.medicaap.tomaszwisniowski.repository.UserRepository;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/api/v1/doctors").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/doctors").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/doctors").hasRole("ADMIN")
                .antMatchers("/api/v1/doctors").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/nurses").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/nurses").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/nurses").hasRole("ADMIN")
                .antMatchers("/api/v1/nurses").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/patients").hasAnyRole("ADMIN", "NURSE")
                .antMatchers(HttpMethod.PUT, "/api/v1/patients").hasAnyRole("ADMIN", "NURSE")
                .antMatchers(HttpMethod.POST, "/api/v1/patients").hasAnyRole("ADMIN", "NURSE")
                .antMatchers("/api/v1/patients").hasAnyRole("ADMIN", "NURSE")
                .antMatchers(HttpMethod.DELETE, "/api/v1/patientsCards").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers(HttpMethod.PUT, "/api/v1/patientsCards").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers(HttpMethod.POST, "/api/v1/patientsCards").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers("/api/v1/patientsCards").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers(HttpMethod.DELETE, "/api/v1/patientsRegistration").hasAnyRole("ADMIN", "NURSE")
                .antMatchers(HttpMethod.PUT, "/api/v1/patientsRegistration").hasAnyRole("ADMIN", "NURSE")
                .antMatchers(HttpMethod.POST, "/api/v1/patientsRegistration").hasAnyRole("ADMIN", "NURSE")
                .antMatchers("/api/v1/patientsRegistration").hasAnyRole("ADMIN", "NURSE")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

/*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();


        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(admin);

        return userDetailsManager;

    }
*/

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }


}
