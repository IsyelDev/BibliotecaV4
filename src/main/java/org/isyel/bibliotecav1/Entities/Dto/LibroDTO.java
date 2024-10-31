package org.isyel.bibliotecav1.Entities;

import lombok.Data;

import java.util.UUID;

@Data
public class LibroDTO {
  private Long isbn;
  private String titulo;
  private Integer ejemplares;
  private  UUID id_autor;
  private String id_editorial;
}
