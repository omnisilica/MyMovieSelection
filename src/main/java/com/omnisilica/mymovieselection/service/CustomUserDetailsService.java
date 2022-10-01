package com.omnisilica.mymovieselection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.omnisilica.mymovieselection.domain.CustomUserDetails;
import com.omnisilica.mymovieselection.domain.MMSUser;
import com.omnisilica.mymovieselection.repository.MMSUserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private MMSUserRepository mmsUserRepository;
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MMSUser mmsUser = mmsUserRepository.findUserByEmail(email);
        if (mmsUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(mmsUser);
    }

}
