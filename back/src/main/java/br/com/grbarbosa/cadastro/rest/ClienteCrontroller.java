package br.com.grbarbosa.cadastro.rest;

import br.com.grbarbosa.cadastro.model.entity.Cliente;
import br.com.grbarbosa.cadastro.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteCrontroller {


    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteCrontroller(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar( @RequestBody @Valid Cliente cliente ){
        return clienteRepository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId( @PathVariable Integer id ){
        return clienteRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado!"));
    }

    @DeleteMapping("{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deletar( @PathVariable Integer id ){
        clienteRepository
                .findById(id)
                .map( cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado!"));
    }

    @PutMapping("{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        clienteRepository
                .findById(id)
                .map( cliente -> {
                    cliente.setCpf(clienteAtualizado.getCpf());
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEndereco(clienteAtualizado.getEndereco());
                    cliente.setEmail(clienteAtualizado.getEmail());
                  return clienteRepository.save(cliente);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado!" ));
    }
}
