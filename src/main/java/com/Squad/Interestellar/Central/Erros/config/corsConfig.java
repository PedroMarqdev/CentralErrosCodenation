package com.Squad.Interestellar.Central.Erros.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class corsConfig {
 @Bean
 public FilterRegistrationBean customCorsFilter() {
	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	final CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("https://central-errors.vercel.app/");
	config.addAllowedHeader("*");
	config.addAllowedMethod("*");
	source.registerCorsConfiguration("/**", config);
	final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
 }
}
