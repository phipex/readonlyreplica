package co.com.ies.pruebas.readonlyreplica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WebsiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String email;


    public long getId() {
        return id;
    }

    public WebsiteUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WebsiteUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WebsiteUser setEmail(String email) {
        this.email = email;
        return this;
    }
}