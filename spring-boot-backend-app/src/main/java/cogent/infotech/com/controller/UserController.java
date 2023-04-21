package cogent.infotech.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cogent.infotech.com.enity.User;

import cogent.infotech.com.service.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService sv;
	
	//Add book
	@PostMapping("/user")
	public User add (@RequestBody User user) {
		return sv.save(user);
	}
	
	//List all book
	@GetMapping("/user")
	public List<User> listAll(){
		return sv.listall();
	}
	
	//List one book by id
	@GetMapping("/user/{userId}")
	public User get(@PathVariable("userId") Long id) {
		Optional<User> b = sv.find(id);
		return b.get();
	}
	
	@PutMapping("/book")
	public User update(@RequestBody User user) {
		return sv.save(user);
	}
	
	@DeleteMapping("/book")
	public String delete (@RequestParam (value="id") Long id) {
		Optional<User> b = sv.find(id);
		sv.delete(b.get());
		return "Book USer";
	}
	
}
