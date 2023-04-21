package cogent.infotech.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cogent.infotech.com.enity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
