package models.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "T_COMMNET")
public class Comment extends Model {

  public String author;
  
  public Date postedAt;
  
  @Lob
  public String content;
  
  @ManyToOne
  public Post post;
  
}
