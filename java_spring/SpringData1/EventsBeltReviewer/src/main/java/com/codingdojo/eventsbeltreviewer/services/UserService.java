package com.codingdojo.eventsbeltreviewer.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
    

// ------------------------------------------------------------------------------------
// Register User
// ------------------------------------------------------------------------------------

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

// ------------------------------------------------------------------------------------
// Authenticate User
// ------------------------------------------------------------------------------------

    // authenticate user
    public boolean authenticateUser(String email, String password) {
    	User user = userRepository.findByEmail(email);
    	if(user == null) {
    		return false;
    	} else {
    		if(BCrypt.checkpw(password, user.getPassword())) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }

// ------------------------------------------------------------------------------------
// Find User by Email
// ------------------------------------------------------------------------------------

	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
// ------------------------------------------------------------------------------------
// Find User by Id
// ------------------------------------------------------------------------------------

    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
}

