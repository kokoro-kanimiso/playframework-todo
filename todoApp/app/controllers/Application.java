package controllers;

import models.Tasks;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	
	static Form<Tasks> taskForm = Form.form(Tasks.class);

	public static Result index() {
        return redirect(routes.Application.todos());
    }

      
	public static Result todos() {
		return ok(views.html.index.render(Tasks.all(), taskForm));
	}
	
	public static Result createTodo() {
		
		Form<Tasks> filledForm = taskForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(
					views.html.index.render(Tasks.all(), filledForm));
		}else {
			Tasks.create(filledForm.get());
			return redirect(routes.Application.todos());
		}
		
	}
	
	public static Result deleteTodo(Long id) {
		return TODO;
	}

}
