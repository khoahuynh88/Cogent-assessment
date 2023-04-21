package cogent.infotech.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.infotech.com.enity.User;
import cogent.infotech.com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	
	

	@Override
	public List<User> listall() {
		// TODO Auto-generated method stub
		return (List<User>) repo.findAll();}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
	}








	@Override
	public User update(long id, User user) {
		// TODO Auto-generated method stub
		user.setId(id);
		return repo.save(user);
	}




	@Override
	public Optional<User> find(long userId) {
		// TODO Auto-generated method stub
		return repo.findById(userId);
	}


	

		

	
	

}
