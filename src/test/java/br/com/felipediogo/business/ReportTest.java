package br.com.felipediogo.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1;
import static br.com.felipediogo.business.builders.ClientBuilder.buildClient2;
import static br.com.felipediogo.business.builders.SaleBuilder.*;
import static br.com.felipediogo.business.builders.SellerBuilder.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ReportTest {

    private Report report;
    private final static String REPORT_NAME = "mock.file";
    @Before
    public void setup() {
        report = new Report(REPORT_NAME);
    }

    /*
     * Mesmo adicionando três clientes deve retornar só 2, porque estamos adicionando dois clientes iguais
     */
    @Test
    public void testShouldCalculateClientCount() {
        addClients();
        assertThat(Integer.valueOf(report.getClientsCount()), is(equalTo(2)));
    }

    /*
     * Mesmo adicionando 7 vendedores deve retornar só 3, porque só temos três vendedores diferentes
     */
    @Test
    public void testShouldCalculateSellerCount() {
        addSellers();
        assertThat(Integer.valueOf(report.getSellersCount()), is(equalTo(3)));
    }

    /*
     * Deve calcular de forma correta os dados de maior venda e pior vendedor, existem duas vendas iguais cadastradas
     * esse item deve ser ignorado
     */
    @Test
    public void testShouldCalculateBiggestSale() {
        addSales();
        assertThat(Double.valueOf(report.getMostExpensiveSale()), is(equalTo(150.0)));
    }

    /*
     * Deve calcular de forma correta os dados de maior venda e pior vendedor, existem duas vendas iguais cadastradas
     * esse item deve ser ignorado
     */
    @Test
    public void testShouldCalculateWorstSeller() {
        addSales();
        assertThat(report.getWorstSeller(), is(equalTo(NOME_1)));
    }

    @Test
    public void testShouldHaveFileName() {
        assertThat(report.getFileName(), is(equalTo(REPORT_NAME)));
    }

    private void addClients() {
        report.addClient(buildClient1());
        report.addClient(buildClient1());
        report.addClient(buildClient2());
    }

    private void addSellers() {
        report.addSeller(buildSeller1());
        report.addSeller(buildSeller2());
        report.addSeller(buildSeller3());
        report.addSeller(buildSeller2());
        report.addSeller(buildSeller1());
        report.addSeller(buildSeller1());
        report.addSeller(buildSeller1());
    }

    private void addSales() {
        report.addSale(buildSale1());
        report.addSale(buildSale2());
        report.addSale(buildSale3());
        report.addSale(buildSale3());
        report.addSale(buildSale4());
        report.addSale(buildSale5());
        report.addSale(buildSale6());
        report.addSale(buildSale7());
        report.addSale(buildSale8());
    }


}
