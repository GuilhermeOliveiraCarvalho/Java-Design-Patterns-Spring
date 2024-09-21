package one.digitalInnovation.java_design_patterns.service;

import one.digitalInnovation.java_design_patterns.model.Client;



public interface ClientService {
    Iterable<Client> searchAll();
    Client searchAllById(Long id);

    void insert(Client client);
    void update (Long id, Client client);
    void delete (Long id);
}
