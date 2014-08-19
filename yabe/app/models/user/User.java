package models.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "T_USER")
public class User extends Model {

	@Required
	public String name;

	@Required
	public String password;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

}
