package com.demo.tecmanager.document;

import com.demo.tecmanager.enums.Rol;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Document(collection = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Usuario {

    @Id
    private String id;       // MongoDB usa String como ID (ObjectId internamente)

    @Field("nombre")
    @NonNull
    private String nombre;

    @Indexed(unique = true)  // Email único a nivel de base de datos
    @Field("email")
    @NonNull
    private String email;

    @Field("contrasena")     // Nunca exponer en respuestas - se cifra con BCrypt
    @NonNull
    private String contrasena;

    @Field("rol")
    @Builder.Default
    private Rol rol = Rol.TECNICO;   // Por defecto es técnico

    @Field("activo")
    @Builder.Default
    private boolean activo = true;

    @Field("fecha_creacion")
    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

}