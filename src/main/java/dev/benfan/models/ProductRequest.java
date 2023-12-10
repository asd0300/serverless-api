package dev.benfan.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotEmpty(message = "Product name is undefined.")
    private String name;

    @NotNull
    @Min(value = 0, message = "Price should be greater or equal to 0.")
    private Integer price;
}
