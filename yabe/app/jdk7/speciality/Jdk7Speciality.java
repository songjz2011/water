package jdk7.speciality;

import java.nio.file.FileSystem;

public class Jdk7Speciality {

  public void switchString(String type) {
    switch (type) {
    case "name":
      System.out.println("my name is lilei...");
      break;
    case "age":
      System.out.println("my age is 12...");
      break;
    default:
      break;
    }
  }

  public void environmentVariable() {
    // Properties ps = System.getProperties();
    // for(Map.Entry<Object,Object> entry : ps.entrySet()) {
    // System.out.println(entry.getKey() + "=" + entry.getValue());
    // }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Jdk7Speciality j = new Jdk7Speciality();
    j.switchString("name");
    j.environmentVariable();
  }

}
