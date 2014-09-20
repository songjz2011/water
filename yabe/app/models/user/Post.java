package models.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "T_POST")
public class Post extends Model{
public String title;
public Date postedAt;
@Lob
public String content;
}
