package com.podkutin.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by apodkutin on 9/2/2016.
 */
@Entity
public class ClientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientDO", fetch = FetchType.EAGER)
    private List<OrderDO> ordersDO = new ArrayList<>();

    protected ClientDO() {}

    public ClientDO(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OrderDO> getOrdersDO() {
        return ordersDO;
    }

    public void setOrdersDO(List<OrderDO> ordersDO) {
        this.ordersDO = ordersDO;
    }

    @Override
    public String toString() {
        return String.format("ClientDO[id=[%s], login=[%s], firstName=[%s], lastName=[%s], orders=[%s]]",
                this.id,
                this.login,
                this.firstName,
                this.lastName,
                this.ordersDO != null ? this.ordersDO : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDO client = (ClientDO) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(login, client.login) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {

        int result = 0;

        if (this == null)
            return result;

        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.login == null ? 0 : this.login.hashCode());
        result = 31 * result + (this.firstName == null ? 0 : this.firstName.hashCode());
        result = 31 * result + (this.lastName == null ? 0 : this.lastName.hashCode());

        return result;
    }
}
