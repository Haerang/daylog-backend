package com.kbstar.daylog.common.jwtkkang;

import com.kbstar.daylog.common.jwt.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private AuthService authService;
    @Autowired
    private CustomUserDetailsService service;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        //request로부터 "Authorization" 이라는 Header 값을 추출해낸다. JWT를 발급받고 그 값을 Authorization이라는
        //Header에 넣어서 다시 요청을 보낸 것이다.
        String token = httpServletRequest.getHeader("Authorization");
        String userName = null;

        //authorizationHeader에 값이 있고 이 값이 "Bearer "로 시작한다면 authorizationHeader를 통해 token을 추출해낼수 있다.
        //"Bearer "가 7자이기 때문에 위와 같이 substring을 한 것이고 추출한 token 값을
        //jwtUtil 이라는 JWT를 발급 또는 해석해주는 클래스를 통해 userName을 추출한다.
        if (token != null) {
            System.out.println("doFilterInternal.....2.......");
            userName = authService.extractUsername(token);
            System.out.println("JwtFilter : userName - " + userName);
        }
        //추출한 userName이 null이 아니라는것은 token의 값이 정상적이라는것을 나타내고,
        //SecurityContextHolder (Spring Security의 필요한 값을 담는 공간)의 authentication이 비어 있다면
        //이는 최초 인증이라는 뜻이므로 userName을 통해서 Spring Security Authentication에 필요한 정보를 setting 한다.
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("doFilterInternal.....3.......");
            UserDetails userDetails = null;
            try {
                userDetails = service.loadUserByUsername(userName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (authService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        //작업이 끝났으면 다음 필터를 수행하기 위한 Chain을 태운다.
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
