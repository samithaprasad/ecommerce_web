package com.apiforbeuty.beutyweb.pkgdto;

public class DTOProduct {

    private Long id;
    private String name;
    private Integer categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;

//    getters and setters

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

//    constructors

    public DTOProduct(){}

    public DTOProduct(DTOProduct dtoProduct) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.imageName = imageName;
    }

}
