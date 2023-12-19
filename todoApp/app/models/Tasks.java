package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Tasks extends Model {
	
	@Id
	public Long id;
	
	@Required(message = "タスク内容は必須です")
	public String label;
	
	public static Finder<Long, Tasks> find = new Finder(Long.class, Tasks.class);
	
	public static List<Tasks> all(){
		return find.all();
	}
	
	public static void create(Tasks task) {
		task.save();
	}
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	
	
}