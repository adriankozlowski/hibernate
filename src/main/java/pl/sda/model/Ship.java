package pl.sda.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
public class Ship {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column(name = "production_year")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productionYear;

    @Column
    private Integer countOfMast;

    @Column
    private Integer power;

    @Column
    private Integer length;

    @Column
    private Integer weigth;

    @Column
    private Integer velocity;

    @OneToMany(mappedBy = "ship"
            , cascade = CascadeType.ALL
            , fetch = FetchType.EAGER)
    private Set<Cabin> cabins;

    public Set<Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(Set<Cabin> cabins) {
        this.cabins = cabins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Date productionYear) {
        this.productionYear = productionYear;
    }

    public Integer getCountOfMast() {
        return countOfMast;
    }

    public void setCountOfMast(Integer countOfMast) {
        this.countOfMast = countOfMast;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeigth() {
        return weigth;
    }

    public void setWeigth(Integer weigth) {
        this.weigth = weigth;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }
}
