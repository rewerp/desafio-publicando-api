package dio.desafio_publicando_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.desafio_publicando_api.model.Cliente;
import dio.desafio_publicando_api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public void inserir(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	} 
	
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBanco = clienteRepository.findById(id);
		
		if (clienteBanco.isPresent()) {		
			cliente.setId(id);
			clienteRepository.save(cliente);
		}
	}
	
}
