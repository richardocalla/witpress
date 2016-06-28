package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	public String firstName;
	public String lastName;
	public String email;
	public String password;

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public static User findByEmail(String email) {
		return find("email", email).first();
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

}