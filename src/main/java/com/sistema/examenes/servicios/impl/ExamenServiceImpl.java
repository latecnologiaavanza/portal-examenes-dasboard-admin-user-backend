package com.sistema.examenes.servicios.impl;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.repositorios.ExamenRepository;
import com.sistema.examenes.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return examenRepository.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        examenRepository.delete(examen);
    }

    @Override
    public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
        return this.examenRepository.findByCategoria(categoria);
    }

    @Override
    public List<Examen> obtenerExamenesActivos() {
        return examenRepository.findByActivo(true);
    }

    @Override
    public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
        return examenRepository.findByCategoriaAndActivo(categoria,true);
    }
}
