package fr.utbm.lo54.primeProject.service;

import fr.utbm.lo54.primeProject.entity.Client;
import fr.utbm.lo54.primeProject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("clientService")
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void persist(Client client) {
        clientRepository.saveAndFlush(client);
    }

}
