package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {



    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }


    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public User getUser(String model, Integer series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User as u left join Car as c on c.user.id = u.id \n" +
                        "where c.model = :model and c.series = : series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList().get(0);
    }
}
