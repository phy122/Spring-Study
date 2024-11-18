package com.aloha.security5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity              // 해당 클래스를 스프링 시큐리티 설정 빈으로 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
    private PasswordEncoder passwordEncoder;        // 비밀번호 암호화 객체

    
		
		@Override
    protected void configure(HttpSecurity http) throws Exception {
            // ÀÎ°¡ ¼³Á¤
            http.authorizeRequests(requests -> requests
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated());

            // 폼 로그인 설정
            http.formLogin(login -> login.permitAll());
    }



    /**
     * 👮‍♂️🔐사용자 인증 관리 메소드
     * ⭐ 인메모리 인증 방식
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // AuthenticationManagerBuilder : 인증 관리 객체
        auth.inMemoryAuthentication()               
            // .withUser("아이디").password("비밀번호").roles("권한")
            // passwordEncoder.encode("비밀번호")     :   비밀번호 암호화
            // BCryptPasswordEncoder 사용
            .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN")
            ;
            // NoOpPasswordEncoder 사용
            // .withUser("user").password("123456").roles("USER")
            // .and()
            // .withUser("admin").password("123456").roles("ADMIN")
            // ;
    }

}
