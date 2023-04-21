package cogent.infotech.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.enity.User;
import cogent.infotech.com.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("user")
	public List<User> getUsers(){
		return this.userRepo.findAll();
	}
}
