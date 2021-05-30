package com.eNIC.services.eNICservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eNIC.services.eNICservices.entity.Useraccount;
import com.eNIC.services.eNICservices.orgRepository.UserAccRepository;

@Service
public class UserServiceImpl implements UserService {
	   @Autowired
	    private UserAccRepository userAccRepository;
    

    @Override
    public Useraccount findByUsername(String username) {
        return userAccRepository.findByUsername(username);
    }
}