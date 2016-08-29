package hr.vvg.spring.controller;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import hr.vvg.spring.binder.ProjectPropertyEditor;
import hr.vvg.spring.binder.UserPropertyEditor;
import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;
import hr.vvg.spring.service.TaskService;
import hr.vvg.spring.validator.TaskValidator;

@Controller
@SessionAttributes(value={"userList", "projectList", "hoursList"})
public class CreateTaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/createTask.html", method=RequestMethod.GET)
	public String fetchDataAndShowScreen(Model model) {
		
		
		//Integer userID = null;
		
		//List<Integer> rowTaskList = new ArrayList<>();
		
		//Integer countRows;
		
		List<User> userList = taskService.fetchAllUsers();
		
		//for (User user : userList) {
		   
			//userID = user.getUserId();
			
			//countRows = taskService.totalTaskCount(userID);
			
			//rowTaskList.add(countRows);
		//}
		
		List<Integer> maxHours = new ArrayList<>();

		
		List<Project> projectList = taskService.fetchAllProjects();
		
		Integer projectId = null;
		
		for (Project project : projectList) {
		   
			projectId = project.getProjectId();
			
			List <Integer> tempMaxHourList;
			
			tempMaxHourList = taskService.fetchMaxProjectHours(projectId);
			
			maxHours.addAll(tempMaxHourList);
		}

		
		
		List<Integer> hoursList = taskService.fetchHoursOptions();
		List<Task> tasksList = taskService.fetchAllTasks();
		//model.addAttribute("rowTaskList", rowTaskList);
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("userList", userList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("hoursList", hoursList);
		model.addAttribute("maxHours", maxHours);
		model.addAttribute("task", new Task());
		
		return "createTask";
	}
	
	@RequestMapping(value="/createTask.html", method=RequestMethod.POST)
	public String saveTask(Model model, @ModelAttribute("task") Task task, BindingResult result) {
	
		Validator validator = new TaskValidator();
		validator.validate(task, result);
		
		if(result.hasErrors()) {
			
			return "createTask";
			
		}
	
		taskService.saveTask(task);
		return "redirect:fetchAllTasks.html";
	}
	

	
	@InitBinder
	protected void initBinder(HttpServletRequest  request, ServletRequestDataBinder binder) {
	
		binder.registerCustomEditor(User.class, new UserPropertyEditor(taskService));
		binder.registerCustomEditor(Project.class, new ProjectPropertyEditor(taskService));
		
	}

}
