package hiber.model;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    private Long id;

    @Column(name = "model")
    private String model;


    @Column(name = "series")
    private Integer series;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    private User user;

    public Car() {}

    public Car(String model, Integer series) {
        this.model = model;
        this. series = series;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
