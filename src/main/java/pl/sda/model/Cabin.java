package pl.sda.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cabin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Integer number;

    @Column
    private Integer capacity;

    @Column(name = "class")
    private Integer luxuryClass;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    public Long getId() {
        return id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getLuxuryClass() {
        return luxuryClass;
    }

    public void setLuxuryClass(Integer luxuryClass) {
        this.luxuryClass = luxuryClass;
    }
}
