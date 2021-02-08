package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.CacheRequest;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User dimon  = new User("Dimon", "Dimonov", "dimon@mail.ru");
      dimon.setCar(new Car("Bumer", 248));

      User brawn = new User("Emmett", "Brawn", "brawn@mail.ru");
      brawn.setCar(new Car("Delorean", 2017));

      User batman =new User("Bruce", "Wayne", "batman@yandex.ru");
      batman.setCar(new Car("batmobile", 999));

      userService.add(dimon);
      userService.add(brawn);
      userService.add(batman);

      userService.listUsers().forEach(System.out::println);

      User findUser = userService.getUser("batmobile", 999);
      System.out.println(findUser);

      context.close();
   }
}
