package com.BoraDeCompra.DTO;

public record TokenDTO(String type, String token) {

    public TokenDTO (String token) {
        this("Bearer", token);
    }
}
