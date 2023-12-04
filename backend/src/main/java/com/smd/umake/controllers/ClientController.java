package com.smd.umake.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smd.umake.dtos.ClientDTO;
import com.smd.umake.entities.Client;
import com.smd.umake.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/client")
@Tag(name="Cliente")
public class ClientController{

  @Autowired
  private ClientService clientService;

  @Operation(summary="Retorna um cliente pelo ID", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Cliente encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Cliente não foi encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
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
  @Operation(summary="Retorna um cliente pelo Nome", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Cliente encontrado e retornado com sucesso"),
    @ApiResponse(responseCode = "404", description="Cliente não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("/")
  public ResponseEntity<Client> getClientByName(@RequestParam("name") String name) throws Exception {
    Client p = clientService.getClientByName(name);
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Retorna todos os clientes", method="GET")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Clientes retornado com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @GetMapping("")
  public ResponseEntity<List<Client>> getClients() throws Exception {
    List<Client> p = clientService.getClients();
    if (p == null){
      throw new Exception();
    } else {
      return new ResponseEntity<> (p,HttpStatus.OK);
    }
  }
  @Operation(summary="Deleta um cliente pelo ID", method="DELETE")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Cliente deletado com sucesso"),
    @ApiResponse(responseCode = "404", description="Cliente não foi encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteClientById(@PathVariable String id) throws Exception {
    String result = clientService.deleteClient(id);
    return new ResponseEntity<String>(result,HttpStatus.OK);
  }
  @Operation(summary="Cria um cliente", method="POST")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Cliente criado com sucesso"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PostMapping("/")
  public ResponseEntity<Client> addClient(@RequestBody ClientDTO  newClient) throws Exception{
    Client cli = clientService.createClient(newClient);
    if (cli == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Client>(cli, HttpStatus.CREATED);
    }

  }
  @Operation(summary="Atualiza as informações do cliente", method="PATCH")
  @ApiResponses( value = {
    @ApiResponse(responseCode = "200", description="Cliente atualizado com sucesso"),
    @ApiResponse(responseCode = "404", description="Cliente não encontrado"),
    @ApiResponse(responseCode = "400", description="Parâmetros inválidos"),
  } )
  @PatchMapping("/{id}")
  public ResponseEntity<Client> updatePartialClientById(@PathVariable String id, @RequestBody ClientDTO updatedData) throws Exception {
    Client prod = clientService.updatePartialClient(id, updatedData);
    if (prod == null){
      throw new Exception();
    } else {
      return new ResponseEntity<Client>(prod, HttpStatus.CREATED);
    }
  }

}
