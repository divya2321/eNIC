package com.eNIC.drp.api.eNICdrpAPI.enicrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eNIC.drp.api.eNICdrpAPI.enicentity.OldNic;

public interface OldNicRepository extends JpaRepository<OldNic, Integer> {

}
