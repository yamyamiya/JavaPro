package de.telran.lesson3.domain_layer.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.telran.lesson3.domain_layer.entity.Cart;
import de.telran.lesson3.domain_layer.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    @NotBlank
    private String name;

    @Column(name = "age")
    @Min(value=14)
    @Max(value = 130)
    private int age;

    @Column(name = "email")
//    @Pattern(regexp = "\\w{1,}[@][a-z]{1,}[.][a-z]{2,4}")
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    @NotBlank
    private String password;



    @OneToOne(mappedBy = "customer",
            cascade = CascadeType.ALL)
    private JpaCart cart;

    private static final Logger LOGGER = LogManager.getLogger(JpaCustomer.class);

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_role",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    public JpaCustomer() {
        LOGGER.info(String.format("INFO Вызван конструктор JpaCustomer()"));
    }

    public JpaCustomer(int id, String name, JpaCart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
        LOGGER.info(String.format("INFO Вызван конструктор JpaCustomer(int id, String name, JpaCart cart) c id= %d, name= %s и cart= %s.", id, name, cart.toString()));
    }

    public JpaCustomer(int id, String name) {
        this.id = id;
        this.name = name;
        LOGGER.info(String.format("INFO Вызван конструктор JpaCustomer(int id, String name) c id= %d и name= %s.", id, name));
    }

    public JpaCustomer(int id, @NonNull String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public int getId() {
        LOGGER.info(String.format("INFO Вызван метод getId()"));
        return id;
    }

    @Override
    public String getName() {
        LOGGER.info(String.format("INFO Вызван метод getName()"));
        return name;
    }

    @Override
    public Cart getCart() {
        LOGGER.info(String.format("INFO Вызван метод getCart()"));
        return cart;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "JpaCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
