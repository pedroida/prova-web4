package br.edu.utfpr.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String role;

    public UserRoleBean() {

    }

    public UserRoleBean(String name, String role) {
        this.name = name;
        this.role = role;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
