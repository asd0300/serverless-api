package dev.benfan.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
    private String id;
    private String name;
    private int price;

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    private String oldid;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

