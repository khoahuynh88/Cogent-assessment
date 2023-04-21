package cogent.infotech.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public User get(@PathVariable("userId") long id) {
		Optional<User> b = sv.find(id);
		return b.get();
	}
	
	 @PutMapping("user/{id}")
	    public ResponseEntity<User> updateMovie(@PathVariable long id, @RequestBody User user) {
	        Optional<User> updatedUser =sv.find(id)
	                .map(existingMovie -> sv.update(id, user));
	        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        Optional<User> user = sv.find(id);
        if (user.isPresent()) {
            sv.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
}
