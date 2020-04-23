package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${oauth2.access-token-uri}")
    private String tokenUri;
    @Value("${oauth2.client-id}")
    private String clientId;
    @Value("${oauth2.client-secret}")
    private String clientSecret;

    @Bean
    protected OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
        final ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(tokenUri);
        details.setGrantType("client_credentials");
        details.setId("ui");
        return details;
    }

    @Bean
    public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
        final AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(oAuth2ProtectedResourceDetails, new DefaultOAuth2ClientContext(atr));
    }

}
