package com.lofitskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ebayLink;
    private String amzLink;
    private String sku;
    private String docPrice;
    private String amzPrice;

    public Item(String name, String ebayLink, String amzLink, String sku, String docPrice, String amzPrice) {
        this.name = name;
        this.ebayLink = ebayLink;
        this.amzLink = amzLink;
        this.sku = sku;
        this.docPrice = docPrice;
        this.amzPrice = amzPrice;
    }
}
