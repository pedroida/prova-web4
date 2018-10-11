package br.edu.utfpr.model;

import javax.persistence.*;
import java.util.Date;

public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "validity")
    @Temporal(TemporalType.DATE)
    private Date validity;

    @Column(name = "unit")
    private String unit;

    public Product() {

    }

    public Product(String title, String description, float quantity, double price, Date validity, String unit) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.validity = validity;
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
