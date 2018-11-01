package br.edu.utfpr.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany
    private Collection<ProductBean> productBeans;

    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserBean() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<ProductBean> getProductBeans() {
        return productBeans;
    }

    public void setProductBeans(Collection<ProductBean> productBeans) {
        this.productBeans = productBeans;
    }
}
