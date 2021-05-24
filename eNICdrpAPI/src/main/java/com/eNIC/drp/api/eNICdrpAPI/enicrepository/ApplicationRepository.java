package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eNIC.drp.api.eNICdrpAPI.enicentity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
