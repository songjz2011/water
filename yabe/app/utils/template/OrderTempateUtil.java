package utils.template;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;
import groovy.text.TemplateEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import models.user.User;
import play.libs.IO;
import play.templates.BaseTemplate;
import play.templates.GroovyTemplate;
import play.templates.TemplateLoader;
import play.vfs.VirtualFile;

/**
 * 订单短信模板工具
 * 
 * @author jzsong@rongxintx.com
 */
public class OrderTempateUtil {

  public static String getEmailContent() throws FileNotFoundException {
    // String path = Thread.currentThread().getContextClassLoader()
    // .getResource("orderEmailTempate.txt").getPath();
    Map<String, Object> templateTextBinding = new HashMap<String, Object>();
    templateTextBinding.put("name", "张三");
    templateTextBinding.put("newpassword", "111111");
    String path = OrderTempateUtil.class.getResource("orderEmailTempate.txt").getPath();
    System.out.println(path);
    File file = new File(path);

    BaseTemplate basetemplate = new GroovyTemplate(file.getName(),
        IO.readContentAsString(new FileInputStream(
            file)));
    String bodyText = basetemplate.render(templateTextBinding);
    System.out.println(bodyText);
    VirtualFile virtualFile = VirtualFile.open(file);
    play.templates.Template template = TemplateLoader.load(path);
    bodyText = template.render(templateTextBinding);
    return bodyText;
  }

  public static void test() throws Exception {
    String fileName = "template" + File.separator + "orderEmailTempate.txt";
    String path = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
    // path =
    // OrderTempateUtil.class.getResource("orderEmailTempate.txt").getPath();
    File file = new File(path);
    TemplateEngine engine = new SimpleTemplateEngine();
    groovy.text.Template template = engine.createTemplate(file);

    User user = new User();
    user.name = "李四";
    // user.password = "7788";

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "张三");
    map.put("newpassword", "111111");
    map.put("user", user);

    Writable result = template.make(map);
    String str = result.toString();

    System.out.println(str);
  }

  public static void main(String[] args) throws Exception {
    OrderTempateUtil.test();
  }

}
