package org.isyel.bibliotecav1.Entities.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class LibroDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private String titulo;
  private Integer ejemplares;
  private  UUID id_autor;
  private String id_editorial;
}
