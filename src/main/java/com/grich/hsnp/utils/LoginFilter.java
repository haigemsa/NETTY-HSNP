package com.grich.hsnp.utils;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.grich.hsnp.service.user.VlabUserService;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFilter implements Filter {
	@Resource
	private VlabUserService sysUserService;

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		RequestHolder.add((HttpServletRequest)servletRequest);
		filterChain.doFilter(servletRequest, servletResponse);
		return;
	}

	public void destroy() {

	}
}
