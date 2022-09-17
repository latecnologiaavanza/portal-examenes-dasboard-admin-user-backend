package com.sistema.examenes.controladores;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }

    @PutMapping("/")
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }

    @GetMapping("/{examenId}")
    public Examen listarExamen(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }

    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable("examenId") Long examenId){
        examenService.eliminarExamen(examenId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Examen> listarExamenesDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return examenService.listarExamenesDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<Examen> listarExamenesActivos(){
        return examenService.obtenerExamenesActivos();
    }

    @GetMapping("/categoria/activo/{categoriaId}")
    public List<Examen> listarExamenesActivosDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return examenService.obtenerExamenesActivosDeUnaCategoria(categoria);
    }
}
