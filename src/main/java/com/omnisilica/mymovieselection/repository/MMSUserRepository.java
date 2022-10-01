package com.omnisilica.mymovieselection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omnisilica.mymovieselection.domain.*;

public interface MMSUserRepository extends JpaRepository<MMSUser, Long> {
	@Query("SELECT u FROM MMSUser u WHERE u.mmsUserEmail = ?1")
    public MMSUser findUserByEmail(String email);
}
