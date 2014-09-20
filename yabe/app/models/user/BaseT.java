package models.user;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

//@AttributeOverride(name = "name", column=@Column(name= "name_t"))
public class BaseT extends Base {

	@Column(nullable= false)
	public String getName(){
		return super.name;
	}
	
}
