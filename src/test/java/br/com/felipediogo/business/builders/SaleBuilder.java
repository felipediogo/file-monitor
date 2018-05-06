package br.com.felipediogo.business.builders;

import br.com.felipediogo.models.Sale;

import static br.com.felipediogo.business.builders.SellerBuilder.*;

public class SaleBuilder {
    public static Sale buildSale1() {
        return new Sale(1, 13.30, NOME_1);
    }

    public static Sale buildSale2() {
        return new Sale(2, 20.70, NOME_1);
    }

    public static Sale buildSale3() {
        return new Sale(3, 150.0, NOME_3);
    }

    public static Sale buildSale4() {
        return new Sale(4, 20.45, NOME_3);
    }

    public static Sale buildSale5() {
        return new Sale(5, 20.50, NOME_2);
    }

    public static Sale buildSale6() {
        return new Sale(6, 100.34, NOME_2);
    }

    public static Sale buildSale7() {
        return new Sale(7, 20.43, NOME_2);
    }

    public static Sale buildSale8() {
        return new Sale(8, 48.95, NOME_2);
    }

    public static String buildSale1Line() {
        return String.format("001ç1ç[1-2-1.30,2-4-1.20,3-2-2.95]ç%s", NOME_1);
    }
}
