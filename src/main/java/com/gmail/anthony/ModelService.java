package com.gmail.anthony;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired UserRepository userRepository ;
	@Autowired ChatRepository chatRepository ;
	
	public User identification(String login, String mdp) {
		Optional<User> userPitEtre = userRepository.findById(login) ;
		if( userPitEtre.isPresent() ) {
			//Le user avec ce login existe
			User u = userPitEtre.get() ;
			if( u.getMdp().equals(mdp)) {
				return u ;
			}
		}
		return null ;
	}

	public void donnerChat(User u , Chat c) {
		chatRepository.save(c) ;
		u.getSesChats().add(c) ;
		userRepository.save(u) ;
	}

}
