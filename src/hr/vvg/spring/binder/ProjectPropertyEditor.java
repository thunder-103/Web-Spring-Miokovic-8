package hr.vvg.spring.binder;

import java.beans.PropertyEditorSupport;

import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.service.TaskService;

public class ProjectPropertyEditor extends PropertyEditorSupport{
	
	private TaskService service;

	public ProjectPropertyEditor(TaskService service) {
	
		this.service = service;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if(text.isEmpty()) {
			
			return;
			
		}
		
		Project project = null;
		
		try {
			
			Integer id = Integer.parseInt(text);
			project = service.fetchProjectById(id);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		setValue(project);
	}

}
