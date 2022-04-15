package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping(value = "/{id}",produces = "application/json") //Pesquisa
    public ResponseEntity <Usuario> init(@PathVariable(value = "id") Long id) {		
    	
		Usuario usuario = usuarioRepository.findById(id).get();

        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
    }


	@GetMapping(value = "/", produces = "application/json")//Pesquisa
	public ResponseEntity<List<Usuario>> usuario() {
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = "application/json") //Cadastra
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	@PutMapping(value = "/", produces = "application/json") //Cadastra
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json") //Deleta
	public ResponseEntity<String> deletar(@PathVariable(value = "id") Long id) {
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
	}
	

}
