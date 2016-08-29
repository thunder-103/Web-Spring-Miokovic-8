package hr.vvg.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import hr.vvg.spring.entitet.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findAll();
	User findOne(Integer id);

}
