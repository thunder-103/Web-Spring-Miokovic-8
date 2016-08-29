package hr.vvg.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import hr.vvg.spring.entitet.Project;


public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	List<Project> findAll();
	Project findOne(Integer id);

}
