package uv.mx.escuela;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@SpringBootApplication
public class EscuelaApplication {
	TreeMap<Integer, Salon> salones = new TreeMap<Integer, Salon>();
	TreeMap<Integer, Profesor> profesores = new TreeMap<Integer, Profesor>();
	int ultimoIntegerSalon = 1;
	int ultimoIntegerProfesor = 1;

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
	}

	@PostMapping("/salones/crear")
	public int agregarSalon(@RequestBody Salon salon) {
		salones.put(ultimoIntegerSalon, salon);

		int id = ultimoIntegerSalon;

		ultimoIntegerSalon++;

		return id;
	}

	@GetMapping("/salones/{numero}")
	public Salon listarSalon(@PathVariable int numero) {
		Salon salon = salones.get(numero);

		return salon;
	}

	@PutMapping("/salones/{numero}/modificar")
	public Salon modificarSalon(@PathVariable int numero, @RequestBody Salon nuevoSalon) {
		salones.put(numero, nuevoSalon);

		return salones.get(numero);
	}

	@DeleteMapping("/salones/{numero}/eliminar")
	public boolean eliminarSalon(@PathVariable int numero) {
		Salon salonOriginal = salones.get(numero);
		Salon salonResultado = salones.remove(salonOriginal);

		int tamanioAnterior = salones.size();
		boolean eliminado = false;

		if (salonResultado != salonOriginal && tamanioAnterior > salones.size()) {
			eliminado = true;
		}

		return eliminado;
	}

	@GetMapping("/salones")
	public List<Salon> mostrarSalones() {
		List<Salon> todos = new ArrayList<Salon>();
		for (int i = 0; i < salones.size(); i++) {
			todos.add(salones.get(i + 1));
		}

		return todos;
	}
	
	@PostMapping("/salones/profesores/crear")
	public int agregarProfesor(@RequestBody Profesor profesor) {
		profesores.put(ultimoIntegerProfesor, profesor);

		int id = ultimoIntegerProfesor;

		ultimoIntegerProfesor++;

		return id;
	}

	@GetMapping("/salones/profesores/{numero}")
	public Profesor listarProfe(@PathVariable int numero) {
		Profesor profesor = profesores.get(numero);

		return profesor;
	}

	@PutExchange("/salones/profesores/{numero}/modificar")
	public Profesor modificarProfesor(@PathVariable int numero, @RequestBody Profesor nuevoProfesor) {
		profesores.put(numero, nuevoProfesor);
	
		return profesores.get(numero);
	}
	
	@DeleteMapping("/salones/profesores/{numero}/eliminar")
	public boolean eliminarProfesor(@PathVariable int numero) {
		Profesor profesorOriginal = profesores.get(numero);
		Profesor profesorResultado = profesores.remove(profesorOriginal);
	
		int tamanioAnterior = salones.size();
		boolean eliminado = false;
	
		if (profesorResultado != profesorOriginal && tamanioAnterior > salones.size()) {
			eliminado = true;
		}
	
		return eliminado;
	}
	
	@GetMapping("/salones/profesores")
	public List<Profesor> mostrarProfesores() {
		List<Profesor> todos = new ArrayList<Profesor>();
		for (int i = 0; i < profesores.size(); i++) {
			todos.add(profesores.get(i + 1));
		}
	
		return todos;
	}
}
