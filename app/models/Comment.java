package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Comment extends Model {
	public String content;
	
	public Comment(String content) {
		this.content = content;
	}
}