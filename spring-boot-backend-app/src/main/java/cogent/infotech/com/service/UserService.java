package cogent.infotech.com.service;

import java.util.List;
import java.util.Optional;

import cogent.infotech.com.enity.User;

public interface UserService {
	
		public User save (User user);
		public Optional<User> find (long userId);
		public List<User> listall();
		public void delete(long  id);
		public void deleteAll ();
		public User update(long id, User user);
	
}
