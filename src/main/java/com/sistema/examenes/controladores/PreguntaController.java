package com.sistema.examenes.controladores;

import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.servicios.ExamenService;
import com.sistema.examenes.servicios.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }

    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }

    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId){
        Examen examen = examenService.obtenerExamen(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas();

        List examenes = new ArrayList(preguntas);
        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0,Integer.parseInt(examen.getNumeroDePreguntas() + 1));
        }

        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }

    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }

    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?> listarPreguntaDelExamenComoAdministrador(@PathVariable("examenId") Long examenId){
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for(Pregunta p : preguntas){
            Pregunta pregunta = this.preguntaService.listarPregunta(p.getPreguntaId());
            if(pregunta.getRespuesta().equals(p.getRespuestaDada())){
                respuestasCorrectas ++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos())/preguntas.size();
                puntosMaximos += puntos;
            }
            if(p.getRespuestaDada() != null){
                intentos ++;
            }
        }

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos",puntosMaximos);
        respuestas.put("respuestasCorrectas",respuestasCorrectas);
        respuestas.put("intentos",intentos);
        return ResponseEntity.ok(respuestas);
    }
}
