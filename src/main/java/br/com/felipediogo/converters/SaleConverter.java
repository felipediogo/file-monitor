package br.com.felipediogo.converters;

import br.com.felipediogo.models.Sale;

import java.util.Optional;

public interface SaleConverter {
    Sale convert(String line);
}
