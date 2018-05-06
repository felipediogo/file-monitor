package br.com.felipediogo.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Client {
    private String cnpj;
    private String name;
    private String business;

    public Client(String cnpj, String name, String business) {
        this.cnpj = cnpj;
        this.name = name;
        this.business = business;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("cnpj='").append(cnpj).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", business='").append(business).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return new EqualsBuilder()
                .append(cnpj, client.cnpj)
                .append(name, client.name)
                .append(business, client.business)
                .isEquals();
    }
}
