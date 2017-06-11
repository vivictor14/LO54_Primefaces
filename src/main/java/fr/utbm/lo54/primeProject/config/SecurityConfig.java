package fr.utbm.lo54.primeProject.config;

import java.util.Arrays;

import fr.utbm.lo54.primeProject.web.login.LoginBean;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UserDetailsService userDetailsService;

    public SecurityConfig(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService) {

        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService = userDetailsService;

    }

    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                    .userDetailsService(userDetailsService);
//                    .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Qualifier("dataSource")
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password from user where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, role from user_role where username=?");
//    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
//                .userDetailsService(userDetailsService())
                .authorizeRequests()
                .antMatchers("/javax.faces.resource/**").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/index.xhtml").permitAll()
                .anyRequest().authenticated()

            .and()
                .exceptionHandling().accessDeniedPage("/403");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails user1 = new User("admin", "admin", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
//        UserDetails user2 = new User("user", "user", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//        return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
//    }
}
