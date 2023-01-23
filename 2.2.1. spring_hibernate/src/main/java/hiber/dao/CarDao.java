package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {

    void add(Car car);

    public User getUser(String model, Integer series);

    List<Car> listCars();

}
