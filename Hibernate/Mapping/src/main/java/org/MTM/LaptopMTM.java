package org.MTM;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class LaptopMTM {

    @Id
    private int lid;

    private String brand;

    private String model;

    private int ram;

    @ManyToMany(mappedBy = "laptops")
    private List<AlienMTM> aliens;

    public List<AlienMTM> getAliens() {
        return aliens;
    }

    public void setAliens(List<AlienMTM> aliens) {
        this.aliens = aliens;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
