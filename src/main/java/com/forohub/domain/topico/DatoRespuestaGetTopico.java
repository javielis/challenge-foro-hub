package com.forohub.domain.topico;

import com.forohub.domain.respuesta.DatosRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatoRespuestaGetTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String status,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion,
        List<DatosRespuesta> respuestas
) {
}
