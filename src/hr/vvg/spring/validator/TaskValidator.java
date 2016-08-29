package hr.vvg.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import hr.vvg.spring.entitet.Task;

public class TaskValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {

		return  Task.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		Task task = (Task) arg0;
		
		if(task.getUser() == null) {
			
			ValidationUtils.rejectIfEmpty(arg1, "user", "invalid.user");
		}
		
		if(task.getProject() == null) {
			
			ValidationUtils.rejectIfEmpty(arg1, "project", "invalid.project");
		}
		
		if(task.getTaskDescription().isEmpty()) {
			
			ValidationUtils.rejectIfEmpty(arg1, "taskDescription", "invalid.taskDescription");
		}
		
		if(task.getEstimatedTime() == null) {
			
			ValidationUtils.rejectIfEmpty(arg1, "estimatedTime", "invalid.estimatedTime");
		}
		
		if(task.getExpiryDate() == null) {
			
			ValidationUtils.rejectIfEmpty(arg1, "expiryDate", "invalid.expiryDate");
		}
		
	}
	
	

}
