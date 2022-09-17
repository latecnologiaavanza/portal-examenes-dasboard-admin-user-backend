package com.sistema.examenes.servicios.impl;


import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.repositorios.CategoriaRepository;
import com.sistema.examenes.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl  implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<>(categoriaRepository.findAll());
    }

    @Override
    public Categoria obtenerCategoria(Long categoriaId) {
        return categoriaRepository.findById(categoriaId).get();
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        categoriaRepository.delete(categoria);
    }
}
