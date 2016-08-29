package hr.vvg.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
public class EditTaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/editTask.html", method=RequestMethod.GET)
	public String editTask(Model model, @ModelAttribute("task") Task task, BindingResult result,
			Integer taskId) {
	
	
		task = taskService.fetchTaskById(taskId);
		
		List<User> userList = taskService.fetchAllUsers();
		List<Project> projectList = taskService.fetchAllProjects();
		List<Integer> hoursList = taskService.fetchHoursOptions();
		List<Task> tasksList = taskService.fetchAllTasks();
		
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("userList", userList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("hoursList", hoursList);	
		//model.addAttribute("task", new Task());
		model.addAttribute("task", task);
		
		return "createTask";
	}
	
	@RequestMapping(value="/editTask.html", method=RequestMethod.POST)
	public String updateTask(Model model, @ModelAttribute("task") Task task, BindingResult result) {
	
		Validator validator = new TaskValidator();
		validator.validate(task, result);
		
		if(result.hasErrors()) {
			
			return "createTask";
			
		}
	
		taskService.updateTask(task);
		return "redirect:fetchAllTasks.html";
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest  request, ServletRequestDataBinder binder) {
	
		binder.registerCustomEditor(User.class, new UserPropertyEditor(taskService));
		binder.registerCustomEditor(Project.class, new ProjectPropertyEditor(taskService));
		// http://stackoverflow.com/questions/17015380/conversion-data-type-in-spring-mvc
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}

}
