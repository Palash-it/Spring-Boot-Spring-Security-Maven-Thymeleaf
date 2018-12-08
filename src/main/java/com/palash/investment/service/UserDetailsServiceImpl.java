package com.palash.investment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.palash.investment.model.UserDetailsImpl;
import com.palash.investment.model.UserModel;
import com.palash.investment.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("-----loadUserByUsername called----:"+username);
		if(StringUtils.isEmpty(username)){
			throw new UsernameNotFoundException("User: "+username + " was not found");
		}
		UserModel userInfo = this.userRepository.findByUsername(username);
		if(userInfo != null) {
			return new UserDetailsImpl(userInfo);
		}
		throw new UsernameNotFoundException("User: "+username +" was not found");
	}

}
