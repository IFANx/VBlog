package com.example.vblogservice.filter;

import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.service.TokenAuthenticationService;
import com.example.vblogservice.util.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JwtLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getAccount(),
                        user.getPassword()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication auth)
        throws ServletException {

        String token = TokenAuthenticationService.addAuthentication(auth.getName());

        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(ResultUtils.success(token).toString());
        } catch (IOException e) {
            logger.error("IO 处理错误");
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().println(ResultUtils.error("5000", "Internal Server Error!!!").toString());
    }
}
