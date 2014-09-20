package models.user;

import javax.persistence.MappedSuperclass;

import play.db.jpa.Model;

@MappedSuperclass
public class Base extends Model{

	public String name;
	
}
