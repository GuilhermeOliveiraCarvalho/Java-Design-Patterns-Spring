package one.digitalInnovation.java_design_patterns.service.impl;

import one.digitalInnovation.java_design_patterns.model.Address;
import one.digitalInnovation.java_design_patterns.model.AddressRepository;
import one.digitalInnovation.java_design_patterns.model.Client;
import one.digitalInnovation.java_design_patterns.model.ClientRepository;
import one.digitalInnovation.java_design_patterns.service.ByCepService;
import one.digitalInnovation.java_design_patterns.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ByCepService byCepService;

    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

  /* @Override
    public Client searchAllById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }*/

    @Override
    public Client searchAllById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID " + id + " not found"));
    }

    @Override
    public void insert(Client client) {
        saveClientByCep(client);
    }


    private void saveClientByCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = byCepService.checkCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }



    @Override
    public void update(Long id, Client client) {

        Optional<Client> clientDb = clientRepository.findById(id);
        if(clientDb.isPresent()){
            saveClientByCep(client);
        }
    }


    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
