package com.example.entities;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerCity;
    private String customerState;
    @Column(name="CUSTOMER_ZIP_POSTAL")
    private String customerZip;

    // getters and setters

    @Override
    public String toString() {
        return "[ Customer Id : " + customerId + ", Customer Name : " + customerName + ", Customer Address : "
                + customerAddress + ", Customer City : " + customerCity + ", Customer State : " + customerState
                + ", Customer Zip Code : " + customerZip + "]";
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Customer customer = (Customer) o;
        return getCustomerId() != null && Objects.equals(getCustomerId(), customer.getCustomerId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}