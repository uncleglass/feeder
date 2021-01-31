//package pl.uncleglass.feeder.backend.app.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final AuthenticationService authenticationService;
//
//    public SecurityConfig(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**", "/h2-console/**").permitAll()
//
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable();
//
////        http.csrf().disable()
////                .requestCache().requestCache(new CustomRequestCache())
////                .and().authorizeRequests()
////                .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
////                .anyRequest().authenticated();
//
//        http.formLogin()
//                .permitAll();
//
//        http.formLogin()
//                .defaultSuccessUrl("/", true);
//    }
//}
