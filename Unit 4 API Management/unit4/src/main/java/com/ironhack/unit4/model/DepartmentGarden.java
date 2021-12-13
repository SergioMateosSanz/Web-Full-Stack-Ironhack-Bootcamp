package com.ironhack.unit4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department_garden")
public class DepartmentGarden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "department")
    private String name;

    @OneToMany(mappedBy = "departmentGarden")
    private List<ProductGarden> productGardenList;

    public DepartmentGarden() {
    }

    public DepartmentGarden(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductGarden> getProductGardenList() {
        return productGardenList;
    }

    public void setProductGardenList(List<ProductGarden> productGardenList) {
        this.productGardenList = productGardenList;
    }
}
