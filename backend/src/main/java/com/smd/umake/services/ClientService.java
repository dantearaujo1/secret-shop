package com.smd.umake.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smd.umake.dtos.ClientDTO;
import com.smd.umake.entities.Client;
import com.smd.umake.entities.ClientContact;
import com.smd.umake.exceptions.ArgumentInvalidException;
import com.smd.umake.exceptions.EntityNotFoundException;
import com.smd.umake.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> getClients() throws Exception {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }
  public Client getClientById(String clientId) throws Exception {
    try{
      UUID id = UUID.fromString(clientId);
      Optional<Client> client = clientRepository.findById(id);
      if(client.isPresent()){
        return client.get();
      }
      throw new EntityNotFoundException("Cliente não encontrado!");
    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Id não é válido!");
    }
  }
  public Client getClientByName(String name) throws Exception {
    Optional<Client> oClient = clientRepository.findDistinctByName(name);
    if (oClient.isPresent()){
      return oClient.get();
    }
    throw new EntityNotFoundException("Cliente não encontrado!");
  }
  public Client createClient(ClientDTO newClient) throws Exception {
    Client client = new Client();
    client.setName(newClient.getName());
    Client dClient = clientRepository.save(client);

    List<ClientContact> contacts = this.createContact(dClient.getId().toString(),newClient.getDdd(),newClient.getPhone());

    dClient.setContacts(contacts);
    clientRepository.save(dClient);

    return dClient;
  }

  public String deleteClient(String clientID) throws Exception {
    try{
      UUID id = UUID.fromString(clientID);
      Optional<Client> oClient = clientRepository.findById(id);
        if (oClient.isPresent()){
          clientRepository.delete(oClient.get());
          return "Client deleted!";
        } else {
          throw new EntityNotFoundException("Cliente não encontrado!");
        }

    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("Id não é válido!");
    }
  }

  public List<ClientContact> createContact(String clientID, List<String> ddd, List<String> phoneNumber) throws Exception {
    try{

      UUID id = UUID.fromString(clientID);
      Optional<Client> client = clientRepository.findById(id);
      List<ClientContact> contacts = new ArrayList<>();
      if (client.isPresent()){

        for (int i = 0; i < phoneNumber.size(); i++){
          ClientContact contact = new ClientContact(client.get(),ddd.get(i),phoneNumber.get(i));
          contacts.add(contact);
        }

      } else{
        throw new EntityNotFoundException("Cliente não encontrado!");
      }
      return contacts;
    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("ID não válido!");
    }

  }

  public Client updatePartialClient(String clientID, ClientDTO updatedClient) throws Exception{
    try{
      UUID id = UUID.fromString(clientID);
      Optional<Client> client = clientRepository.findById(id);
      if (client.isPresent()){

        // TODO: IMPLEMENT
        client.get().setName(updatedClient.getName());
        // client.get().setContacts(updatedClient.getName());


        // WARN: Parece que estamos salvando duas vezes o client quando na verdade queremos dar um update dos contatos dele
        // clientRepository.save(dClient);

        return client.get();
      }
      throw new EntityNotFoundException("Vendedor não encontrado!");
    } catch (IllegalArgumentException e){
      throw new ArgumentInvalidException("ID não válido!");
    }
  }

}
