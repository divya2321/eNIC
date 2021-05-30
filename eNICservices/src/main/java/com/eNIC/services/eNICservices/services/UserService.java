package com.eNIC.services.eNICservices.services;

import com.eNIC.services.eNICservices.entity.Useraccount;

public interface UserService {
    Useraccount findByUsername(String username);
}