package org.isyel.bibliotecav1.Services;

import org.isyel.bibliotecav1.Entities.Autor;
import org.isyel.bibliotecav1.Entities.Dto.AutorDTO;
import org.isyel.bibliotecav1.Entities.Editorial;
import org.isyel.bibliotecav1.Excepciones.ValidationException;
import org.isyel.bibliotecav1.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void createAutor(AutorDTO autorDTO) throws ValidationException {
        validarNombre(autorDTO.getNombre());
        Autor autor = new Autor();
        autor.setNombre(autor.getNombre());
        autorRepository.save(autor);
    }

    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Transactional
    public void UpdateAutor(UUID id, AutorDTO autorDTO) throws ValidationException {
        validarNombre(autorDTO.getNombre());
        Autor autor = validarId(id);
        autor.setNombre(autor.getNombre());
        autorRepository.save(autor);
    }

    @Transactional
    public void deleteEditorial(UUID id) throws ValidationException {
        Autor autor = validarId(id);
        autorRepository.delete(autor);
    }

    private void validarNombre(String nombre) throws ValidationException {
        if (nombre == null || nombre.isEmpty()) {
            throw new ValidationException("El nombre es obligatorio");
        }
    }


    public Autor validarId(UUID id) throws ValidationException {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isEmpty()) {
            throw new ValidationException("No se encontro el id de la Autor");
        }
        return autor.get();
    }

}
