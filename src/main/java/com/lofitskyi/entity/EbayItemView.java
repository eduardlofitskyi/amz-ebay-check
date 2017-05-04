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
    private String sku;
    private String docPrice;
    private String ebayPrice;
}
