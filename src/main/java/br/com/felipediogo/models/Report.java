package br.com.felipediogo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Report {
    String fileName;
    private List<Client> clients;
    private List<Sale> sales;
    private List<Seller> sellers;
    private String worstSeller;
    private Double worstSellerSalesValue;

    public Report(String fileName) {
        this.fileName = fileName;
        this.clients = new ArrayList<>();
        this.sales = new ArrayList<>();
        this.sellers = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void addClient(Client client) {
        if (doesntHaveClient(client)) {
            clients.add(client);
        }
    }

    public void addSeller(Seller seller) {
        if (doesntHaveSeller(seller)) {
            sellers.add(seller);
        }
    }

    public void addSale(Sale sale) {
        if (doesntHaveSale(sale)) {
            sales.add(sale);
        }
    }

    private boolean doesntHaveSale(Sale sale) {
        return sales.stream()
                .noneMatch(f -> f.getId().equals(sale.getId()));
    }

    private boolean doesntHaveClient(Client client) {
        return clients.stream()
                .noneMatch(f -> f.getCnpj().endsWith(client.getCnpj()));
    }

    private boolean doesntHaveSeller(Seller seller) {
        return sellers.stream()
                .noneMatch(f -> f.getCpf().endsWith(seller.getCpf()));
    }

    public String getClientsCount() {
        return String.valueOf(clients.stream().collect(groupingBy(Client::getCnpj)).size());
    }

    public String getSellersCount() {
        return String.valueOf(sellers.stream().collect(groupingBy(Seller::getCpf)).size());
    }

    public String getWorstSeller() {
        Map<String, Double> groupedInformation =
                sales.stream().collect(groupingBy(Sale::getSellerName, summingDouble(Sale::getSaleValue)));

        groupedInformation.forEach((a, b) -> {
            if (worstSeller == null) {
                worstSellerSalesValue = b;
                worstSeller = a;
            } else if (b < worstSellerSalesValue) {
                worstSellerSalesValue = b;
                worstSeller = a;
            }
        });
        return worstSeller;
    }

    public String getMostExpensiveSale() {
        return sales.stream().map(Sale::getSaleValue)
                .reduce((aDouble, aDouble2)
                        -> aDouble > aDouble2 ? aDouble : aDouble2)
                .orElse(0.0).toString();
    }

}
