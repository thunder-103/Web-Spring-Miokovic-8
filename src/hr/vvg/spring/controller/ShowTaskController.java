package hr.vvg.spring.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.service.TaskService;


@Controller
public class ShowTaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/fetchAllTasks.html", method=RequestMethod.GET)
	public String fetchDataAndShowScreen(Model model) {
		

		List<Task> tasksList = taskService.fetchAllTasks();
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("task", new Task());
		
		return "displayTask";
	}

}
