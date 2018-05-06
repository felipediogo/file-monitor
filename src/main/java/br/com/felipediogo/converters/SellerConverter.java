package br.com.felipediogo.converters;

import br.com.felipediogo.models.Seller;

import java.util.Optional;

public interface SellerConverter {
    Seller convert(String line);
}
