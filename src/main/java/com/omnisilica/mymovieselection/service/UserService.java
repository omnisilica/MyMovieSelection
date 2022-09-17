package com.omnisilica.mymovieselection.service;

import com.omnisilica.mymovieselection.domain.*;
import com.omnisilica.mymovieselection.repository.*;

public class UserService {
	
	private MMSUserRepository mmsUserRepository;
	
	public UserService() {}

	void createUser() {
		MMSUser mmsUser = new MMSUser();
		mmsUserRepository.save(mmsUser);
	}

}
