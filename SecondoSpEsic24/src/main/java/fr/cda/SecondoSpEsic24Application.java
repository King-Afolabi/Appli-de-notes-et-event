package fr.cda;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cda.entity.Event;
import fr.cda.entity.Memo;
import fr.cda.entity.User;
import fr.cda.repository.EventRepository;
import fr.cda.repository.MemoRepository;
import fr.cda.repository.UserRepository;
import fr.cda.services.UserServices;

@SpringBootApplication
public class SecondoSpEsic24Application implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private MemoRepository memoRepos;
	
	@Autowired
	private EventRepository eventRepos;

	public static void main(String[] args) {
		SpringApplication.run(SecondoSpEsic24Application.class, args);
		System.out.println("Lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Lancement en cours");
		
		User u1 = new User(null, "Soumia", "Belle", "S", "1234", null);
		userService.saveWithPwdEncoder(u1);
		
		User u2 = new User(null, "Feraht", "Beau", "F", "1234", null);
		userService.saveWithPwdEncoder(u2);
		
		User u3 = new User(null, "Sofiane", "Pro", "Sofi", "1234", null);
		userService.saveWithPwdEncoder(u3);
		
		User u4 = new User(null, "Charaf", "Chasky", "C", "1234", null);
		userService.saveWithPwdEncoder(u4);
		
		List<User> amisU1 = new ArrayList<User>();
		amisU1.add(u4);
		amisU1.add(u2);
		amisU1.add(u3);
		
		u1.setAmis(amisU1);
		userRepos.save(u1);
		
		Memo m1 = new Memo(null, "Mémo Essai", "Contenu de User 1", null, u1);
		memoRepos.save(m1);
		Memo m1_2 = new Memo(null, "Mémo Essai 2", "Contenu de User 1", null, u1);
		memoRepos.save(m1_2);
		Memo m1_3 = new Memo(null, "Mémo Essai 3", "Contenu de User 1", null, u1);
		memoRepos.save(m1_3);
		
		Memo m2 = new Memo(null, "Mémo Essai 2", "Contenu de User 2", null, u2);
		memoRepos.save(m2);
		
		
		// Définir le format de la date
		SimpleDateFormat d = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
		
		// créer un event avec le constructeur plein
		Event e1 = new Event(null, "Event test 1",
				"Rencontre", 
				d.parse ("18/06/2024 09:00"), 
				d.parse ("19/06/2024 21:00"), 
				"Vauguirad", "Marvel", null, true, null, u1); 
		
		//Créer une liste de participants que j'ajoute à e1
		List<User> EventTest1 = new ArrayList<User>();
		EventTest1.add(u1);
		EventTest1.add(u2);
		EventTest1.add(u3);
		
		e1.setParticipants(EventTest1);
		eventRepos.save(e1); // faire la persistance
		
		Event e2 = new Event(null, "Event test 2", 
				"Job Dating", 
				d.parse ("20/06/2024 09:00"), 
				d.parse ("20/06/2024 17:00"), 
				"Vauguirad", "Esic", null, true, null, u2); 
		List<User> EventTest2 = new ArrayList<User>();
		EventTest2.add(u1);
		EventTest2.add(u2);
		EventTest2.add(u4);
		e2.setParticipants(EventTest2);
		eventRepos.save(e2);
		
		
 		
	}
}
