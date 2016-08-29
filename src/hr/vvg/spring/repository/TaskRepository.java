package hr.vvg.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import hr.vvg.spring.entitet.Task;



public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	List<Task> findAll();
	Task findOne(Integer id);

}
