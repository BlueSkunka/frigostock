/*
 * This file is generated by jOOQ.
 */
package com.axopen.frigostrock.model.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Aliment implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer id;
    private final String  name;
    private final Integer price;

    public Aliment(Aliment value) {
        this.id = value.id;
        this.name = value.name;
        this.price = value.price;
    }

    public Aliment(
        Integer id,
        String  name,
        Integer price
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for <code>public.aliment.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.aliment.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.aliment.price</code>.
     */
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Aliment (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(price);

        sb.append(")");
        return sb.toString();
    }
}
