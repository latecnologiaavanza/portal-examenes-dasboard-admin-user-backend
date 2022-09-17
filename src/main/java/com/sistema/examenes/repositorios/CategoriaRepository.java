package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
