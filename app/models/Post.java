package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Post extends Model {
	public String content;
	@Lob
	public String title;
	
	@OneToMany (cascade=CascadeType.ALL)
	public List<Comment> comments;

	public Post(String content, String title) {
		this.content = content;
		this.title = title;
	}
	
}