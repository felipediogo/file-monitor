package br.com.felipediogo.models;

import java.util.ArrayList;
import java.util.List;

public class Report {
    String fileName;
    private List<Client> clients;
    private List<Sale> sales;
    private List<Seller> sellers;

    public Report(String fileName) {
        this.fileName = fileName;
        this.clients = new ArrayList<>();
        this.sales = new ArrayList<>();
        this.sellers = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

}
