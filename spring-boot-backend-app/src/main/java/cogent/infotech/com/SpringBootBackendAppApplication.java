package cogent.infotech.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cogent.infotech.com.enity.User;
import cogent.infotech.com.repository.UserRepository;

@SpringBootApplication
public class SpringBootBackendAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendAppApplication.class, args);
	}

	@Autowired
	private UserRepository userRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.userRepo.save(new User("a1","b1","a1@gmail"));
		this.userRepo.save(new User("a2","b2","a2@gmail"));
		this.userRepo.save(new User("a3","b3","a3@gmail"));
		this.userRepo.save(new User("a4","b4","a4@gmail"));
	}

}
