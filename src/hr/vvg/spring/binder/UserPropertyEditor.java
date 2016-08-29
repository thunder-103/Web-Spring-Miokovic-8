package hr.vvg.spring.binder;

import java.beans.PropertyEditorSupport;

import hr.vvg.spring.entitet.User;
import hr.vvg.spring.service.TaskService;

public class UserPropertyEditor extends PropertyEditorSupport{
	
	private TaskService service;

	public UserPropertyEditor(TaskService service) {
	
		this.service = service;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if(text.isEmpty()) {
			
			return;
			
		}
		
		User user = null;
		
		try {
			
			Integer id = Integer.parseInt(text);
			user = service.fetchUserById(id);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		setValue(user);
	}
}
