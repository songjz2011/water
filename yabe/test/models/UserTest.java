package models;

import models.user.User;

import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class UserTest extends UnitTest{

  @Test
  public void first() {
    Fixtures.loadModels("data.yml");
    assertEquals(1, User.count());
  }
  
}
