package com.lofitskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter @Setter
public class EbayItemView {
    private String name;
    private String ebayLink;
    private String amzLink;
    private String sku;
    private String available;
    private BigDecimal docPrice;
    private String ebayPrice;
    private BigDecimal amzPrice;
}
