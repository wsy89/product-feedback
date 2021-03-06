package leanne.feedback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration class
 */
@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //requires to login when accessing admin page
        http.authorizeRequests()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers("/admin**").access("hasRole('ADMIN')")
                .and()
                    .formLogin().loginPage("/login")
                    .usernameParameter("username").passwordParameter("password")
                    .defaultSuccessUrl("/admin")
                .and().csrf();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("password").roles("ADMIN");
    }
}
