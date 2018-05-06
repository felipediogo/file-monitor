package br.com.felipediogo.business.builders;

import br.com.felipediogo.models.Client;

public class ClientBuilder {
    public static final String CNPJ_1 = "54.423.228/0001-13";
    private static final String CNPJ_2 = "04.645.830/0001-27";

    private static final String NOME_1 = "Fulano da Silva Jr.";
    private static final String NOME_2 = "Ciclano de Alves Pereira";

    private static final String BUSINESS_1 = "Desenvolvedor Pleno";
    private static final String BUSINESS_2 = "Engenheiro de Software";

    public static Client buildClient1() {
        return new Client(CNPJ_1, NOME_1, BUSINESS_1);
    }

    public static Client buildClient2() {
        return new Client(CNPJ_2, NOME_2, BUSINESS_2);
    }

    public static String buildClient1Line() {
        return String.format("001ç%sç%sç%s", CNPJ_1, NOME_1, BUSINESS_1);
    }
}
