package fr.cda.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cda.entity.User;
import fr.cda.repository.UserRepository;
import fr.cda.services.UserServices;

@RestController
@CrossOrigin("*")

public class UserRest {
	
	@Autowired 
	private UserRepository userRepos;
	@Autowired
	private UserServices userServices;
	
	//Créer un user hashé
	@PostMapping("user")
	public User saveUser(@RequestBody User u) {
		return userServices.saveWithPwdEncoder(u);
	}
	
	@PostMapping("users/connexion")
	public Optional<User> connexion(@RequestBody User u) {	
		return userServices.login(u.getLogin(), u.getPassword());
	}
	
/*
 * @PatchMapping("user/classe/apprenant/{id}")
	public Optional<User> addApprenantInClass(@PathVariable Long id, @RequestBody User u) {
		Optional<User> user = userRepos.findById(id);
		if(user.isPresent()) {
			Optional<Classe> c = classeRepos.findById(u.getClasse().getId());
			if(c.isPresent()) {
				user.get().setClasse(c.get());
				userRepos.save(user.get());
				c.get().getApprenants().add(user.get());
				classeRepos.save(c.get());
			}
		}
		return user;
	}
 */

}
