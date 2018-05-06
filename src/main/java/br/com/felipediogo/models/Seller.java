package br.com.felipediogo.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Seller {
    private String cpf;
    private String name;
    private Double salary;

    public Seller(String cpf, String name, Double salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cpf", cpf)
                .append("name", name)
                .append("salary", salary)
                .toString();
    }
}
