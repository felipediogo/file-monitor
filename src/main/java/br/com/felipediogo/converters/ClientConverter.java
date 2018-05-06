package br.com.felipediogo.converters;

import br.com.felipediogo.models.Client;

import java.util.Optional;

public interface ClientConverter {
    Client convert(String line);
}
