package com.sistema.examenes;

import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.modelo.Rol;
import com.sistema.examenes.modelo.Usuario;
import com.sistema.examenes.modelo.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			/*try{
				Usuario usuario = new Usuario();

				usuario.setNombre("Christian");
				usuario.setApellido("Ramirez");
				usuario.setUsername("christian");
				usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
				usuario.setEmail("c1@gmail.com");
				usuario.setTelefono("988212020");
				usuario.setPerfil("foto.png");

				Rol rol = new Rol();
				rol.setRolId(1L);
				rol.setRolNombre("ADMIN");

				Set<UsuarioRol> usuariosRoles = new HashSet<>();
				UsuarioRol usuarioRol = new UsuarioRol();
				usuarioRol.setRol(rol);
				usuarioRol.setUsuario(usuario);
				usuariosRoles.add(usuarioRol);

				Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
				System.out.println(usuarioGuardado.getUsername());
			}catch(UsuarioFoundException exception){
				exception.printStackTrace();
			}*/
	}
}
