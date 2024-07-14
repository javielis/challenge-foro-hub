package com.forohub.infra.security.usuario;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String clave
) {
}
