package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Post extends Model {
	public String content;
	public String title;

	public Post(String content, String title) {
		this.content = content;
		this.title = title;
	}
}