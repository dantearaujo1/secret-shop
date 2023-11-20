package com.smd.umake.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.dtos.ClientDTO;
import com.smd.umake.entities.Client;
import com.smd.umake.services.ClientService;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController{

  @Autowired
  private ClientService clientService;

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable String id) throws Exception {
    Client p = clientService.getClientById(id);
    if (p == null){
      // WARN: Aqui a gente devia enviar uma resposta com o status correto
      // de falha, no caso :)!
      throw new Exception("Não encontramos o cliente!");
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("/")
  public ResponseEntity<Client> getClientByName(@RequestParam("name") String name) throws Exception {
    Client p = clientService.getClientByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @GetMapping("")
  public ResponseEntity<List<Client>> getClients() throws Exception {
    List<Client> p = clientService.getClients();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteClientById(@PathVariable String id) throws Exception {
    String result = clientService.deleteClient(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @PostMapping("/")
  public ResponseEntity<Client> addClient(@RequestBody ClientDTO  newClient) throws Exception{
    Client cli = clientService.createClient(newClient);
    if (cli == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Client>(cli, HttpStatus.CREATED);
    }

  }
  // @PatchMapping("/{id}")
  // public ResponseEntity<Client> updatePartialClientById(@PathVariable UUID id, @RequestBody ClientDTO updatedData) throws Exception {
  //   Client prod = saleService.updatePartialClient(id, updatedData);
  //   if (prod == null){
  //     throw new Exception();
  //   } else {
  //     return new ResponseEntity<Client>(prod, HttpStatus.CREATED);
  //   }
  // }

}
