package com.Squad.Interestellar.Central.Erros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

 private static final int ACCESS_TOKEN_VALIDITY_IN_SECONDS = 360;
 private static final int REFRESH_TOKEN_VALIDITY_IN_SECONDS = 360;

 @Autowired
 private AuthenticationManager authenticationManager;


 @Override
 public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
	security.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
			.allowFormAuthenticationForClients();
 }

 @Override
 public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
	clients.inMemory()
			.withClient("client_id")
			.secret(new BCryptPasswordEncoder().encode("client_secret"))
			.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
			.scopes("read", "write", "trust")
			.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS)
			.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);
 }

 @Override
 public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	endpoints.authenticationManager(authenticationManager)
			.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
 }
}
