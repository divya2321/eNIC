package com.eNIC.services.eNICservices.services;


import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /*
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     */
    protected String determineTargetUrl(final Authentication authentication) {

        Map<String, String> roleTargetUrlMap = new HashMap<>();
        
        roleTargetUrlMap.put("Financial", "http://localhost:8082/swagger-ui/index.html");
        roleTargetUrlMap.put("Healthcare", "http://localhost:8085/swagger-ui/index.html");
        roleTargetUrlMap.put("Judicial", "http://localhost:8086/swagger-ui/index.html");
        roleTargetUrlMap.put("Police", "http://localhost:8087/swagger-ui/index.html");
        
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      
        for (final GrantedAuthority grantedAuthority : authorities) {
       
            String authorityName = grantedAuthority.getAuthority();
           
            if(roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }

 

}