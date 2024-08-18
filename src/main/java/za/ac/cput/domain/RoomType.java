/*
RoomType.java
RoomType domain class
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class RoomType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder
    {
        private final RoomType base;
        public Builder()
        {
            base = new RoomType();
        }

        public Builder id(Long id)
        {
            base.id = id;
            return this;
        }

        public RoomType build()
        {
            return base;
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType that = (RoomType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

}

