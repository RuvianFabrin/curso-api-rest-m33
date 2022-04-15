package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired /* Se Fosse CDI seria @Inject */
	private UsuarioRepository usuarioRepository;

	//Costumizar URL - @GetMapping(value = "/{id}/umNome/{venda}",produces = "application/json")
	//init(@PathVariable(value = "id") Long id, @PathVariable(value = "venda") Long nome)
    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity <Usuario> init(@PathVariable(value = "id") Long id) {		
    	
		Usuario usuario = usuarioRepository.findById(id).get();

        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
    }

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario() {
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
}
