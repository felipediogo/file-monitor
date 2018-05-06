package br.com.felipediogo.business.builders;

import br.com.felipediogo.models.Seller;

public class SellerBuilder {
    private static final String CPF_1 = "017.074.650-02";
    private static final String CPF_2 = "255.510.684-71";
    private static final String CPF_3 = "767.256.736-51";

    public static final String NOME_1 = "Fulano da Silva Jr.";
    public static final String NOME_2 = "Ciclano de Alves Pereira";
    public static final String NOME_3 = "João Teixeira";

    private static final Double SALARIO_1 = 8500.99;
    private static final Double SALARIO_2 = 800.00;
    private static final Double SALARIO_3 = 12000.73;

    public static Seller buildSeller1() {
        return new Seller(CPF_1, NOME_1, SALARIO_1);
    }

    public static Seller buildSeller2() {
        return new Seller(CPF_2, NOME_2, SALARIO_2);
    }

    public static Seller buildSeller3() {
        return new Seller(CPF_3, NOME_3, SALARIO_3);
    }

    public static String buildSeller1Line() {
        return String.format("001ç%sç%sç%s", CPF_1, NOME_1, SALARIO_1);
    }
}
