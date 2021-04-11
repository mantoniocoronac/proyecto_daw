package service;

import org.springframework.security.core.userdetails.UserDetailsService;

import model.User;
import web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
	
}
