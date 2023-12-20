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
	
	public boolean editable;
	

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public static Finder<Long, Tasks> find = new Finder(Long.class, Tasks.class);
	
	public static List<Tasks> all(){
		return find.all();
	}
	
	public static void create(Tasks task) {
		task.save();
	}
	
	public static void update(Long id) {
		Tasks task = new Tasks();
		task = find.byId(id);
		task.setEditable(true);
		task.update();
	}
	
	public static void updateForLabel(Long id,String label) {
		Tasks task = new Tasks();
		task = find.byId(id);
		task.setEditable(false);
		task.label = label;
		task.update();
	}

	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	
	
}