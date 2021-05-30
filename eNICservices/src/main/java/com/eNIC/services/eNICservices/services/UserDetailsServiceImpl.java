package com.eNIC.services.eNICservices.services;

import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.eNIC.services.eNICservices.entity.OrganizationDetail;
import com.eNIC.services.eNICservices.entity.Useraccount;
import com.eNIC.services.eNICservices.orgRepository.OrgRepository;
import com.eNIC.services.eNICservices.orgRepository.UserAccRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserAccRepository userAccRepository;

    @Autowired
    private OrgRepository orgRepository;
    
    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) {
        Useraccount user = userAccRepository.findByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException(username);
        }
        
        System.out.println(username);
        System.out.println(user.getIdUseraccount());
        OrganizationDetail organizationDetail = orgRepository.findByUserAccId(user.getIdUseraccount());
        
        System.out.println(organizationDetail.getOrganizationName());
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        	System.out.println(user.getAccountUsername()+" aaaaaaaa "+ organizationDetail.getOrganizationType());
            grantedAuthorities.add(new SimpleGrantedAuthority(organizationDetail.getOrganizationType()));
   

        return new org.springframework.security.core.userdetails.User(user.getAccountUsername(), user.getAccountPassword(), grantedAuthorities);
    }
}