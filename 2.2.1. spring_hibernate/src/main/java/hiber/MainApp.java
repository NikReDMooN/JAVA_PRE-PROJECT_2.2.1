package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServiceImp;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);


      CarService carService = context.getBean(CarService.class);
      UserService userService = context.getBean(UserService.class);

      Car car = new Car("nissan", 15);
      User user = new User("Nikita", "Pisarenko", "iwanttodie@gmail.com");
      car.setUser(user);
      carService.add(car);
      car = new Car("volvo", 14);
      user = new User("Vika", "Ivanova", "pochta@mail.ru");
      car.setUser(user);
      carService.add(car);
      car = new Car("lada", 1);
      user = new User("Vlad", "Belka", "vlad@yandex.ru");
      car.setUser(user);
      carService.add(car);
      car = new Car("BMV", 3);
      user = new User("Name", "Lastname", "email@gmail.com");
      car.setUser(user);
      carService.add(car);


      List<Car> cars = carService.listCars();
      for (Car c : cars ) {
         System.out.println("Model = " + c.getModel());
         System.out.println("Series = " + c.getSeries());
         System.out.println("user name = " + carService.getUser(c.getModel(), c.getSeries()).getFirstName());
      }
/*      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }*/

      context.close();
   }
}
