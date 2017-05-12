package fr.utbm.lo54.primeProject.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
                    .userDetailsService(userDetailsService())
                    .authorizeRequests()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .antMatchers("/error/**").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/index.xhtml").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login.xhtml")
                    .permitAll()
                    .failureUrl("/login.xhtml?error=true")
                    .successForwardUrl("/")
                    .defaultSuccessUrl("/")
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login.xhtml");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = new User("admin", "admin", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        UserDetails user2 = new User("user", "user", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
    }
}
