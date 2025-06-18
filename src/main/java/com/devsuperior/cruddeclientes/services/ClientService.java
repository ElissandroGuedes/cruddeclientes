package com.devsuperior.cruddeclientes.services;
import com.devsuperior.cruddeclientes.dto.ClientDTO;
import com.devsuperior.cruddeclientes.entities.Client;
import com.devsuperior.cruddeclientes.repositories.ClientRepository;
import com.devsuperior.cruddeclientes.services.exceptions.DatabaseException;
import com.devsuperior.cruddeclientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
       Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
       return new ClientDTO(entity);
    }

    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> entity = repository.findAll(pageable);
        return entity.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id,ClientDTO dto) {
       try{
           Client entity = repository.getReferenceById(id);
           copyDtoToEntity(dto,entity);
           entity = repository.save(entity);
           return new ClientDTO(entity);
       }catch(EntityNotFoundException e){
           throw new ResourceNotFoundException("Recurso não encontrado");
       }
    }

    @Transactional
    public void  delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirth_date());
        entity.setChildren(dto.getChildren());
    }

}
