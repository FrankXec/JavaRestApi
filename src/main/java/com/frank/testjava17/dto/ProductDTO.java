package com.frank.testjava17.dto;

public class ProductDTO {
    //Attributes
    private String productCode;
    private String name;
    private String description;
    private ProductTypeDTO productType;
    
    //Constructors
    public ProductDTO() {
    }

    public ProductDTO(String productCode, String name, String description, ProductTypeDTO productType) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.productType = productType;
    }
    
    //Getters and Setters

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productCode=" + productCode + ", name=" + name + ", description=" + description + ", productType=" + productType.getName() + '}';
    }
    
}
