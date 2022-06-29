package com.frank.testjava17.dto;

public class ProductTypeDTO {
    //ATTRIBUTES
    private Long id;
    private String name;
    private String description;

    //CONSTRUCTORS
    public ProductTypeDTO() {
    }

    public ProductTypeDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //GETTERS AND SETTERS
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductTypeDTO{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
