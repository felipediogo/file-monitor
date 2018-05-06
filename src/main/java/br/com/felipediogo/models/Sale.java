package br.com.felipediogo.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
        final StringBuilder sb = new StringBuilder("Sale{");
        sb.append("id=").append(id);
        sb.append(", saleValue=").append(saleValue);
        sb.append(", sellerName='").append(sellerName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        return new EqualsBuilder()
                .append(id, sale.id)
                .append(saleValue, sale.saleValue)
                .append(sellerName, sale.sellerName)
                .isEquals();
    }

}
