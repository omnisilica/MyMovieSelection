package com.omnisilica.mymovieselection.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private MMSUser mmsUser;
	
	public CustomUserDetails(MMSUser mmsUser) {
		this.mmsUser = mmsUser;
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return mmsUser.getmmsUserPassword();
    }
 
    @Override
    public String getUsername() {
        return mmsUser.getmmsUserUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }

}
