package br.com.felipediogo.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Sale {
    private Integer id;
    private Double saleValue;
    private String sellerName;

    public Sale(Integer id, Double saleValue, String sellerName) {
        this.id = id;
        this.saleValue = saleValue;
        this.sellerName = sellerName;
    }

    public Integer getId() {
        return id;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public String getSellerName() {
        return sellerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("saleValue", saleValue)
                .append("sellerName", sellerName)
                .toString();
    }
}
