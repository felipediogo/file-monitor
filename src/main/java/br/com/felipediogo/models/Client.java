package br.com.felipediogo.models;

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
        return new ToStringBuilder(this)
                .append("cnpj", cnpj)
                .append("name", name)
                .append("business", business)
                .toString();
    }
}
