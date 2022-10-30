package com.viettel.project.controller;

import com.viettel.project.service.ClientDetailService;
import com.viettel.project.service.dto.ClientDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@PreAuthorize(value = "#oauth2.hasScope('write')")
//@PermitAll
public class ClientDetailController {
    @Autowired
    private ClientDetailService clientDetailService;

//    @PreAuthorize(value = "hasRole('ADMIN') && isAuthenticated()")

    @GetMapping(value="/clients")
    public ResponseEntity<List<ClientDetailDTO>> getAll(){
        return ResponseEntity.ok().body(clientDetailService.getAll());
    }

//    @PreAuthorize(value = "hasRole('ADMIN') && isAuthenticated()")

    @PostMapping(value = "/client")
    public ResponseEntity<ClientDetailDTO> accClient(@RequestBody ClientDetailDTO clientDetailDTO) throws Exception {
        return ResponseEntity.ok().body(clientDetailService.addClient(clientDetailDTO));
    }

//    @PreAuthorize(value = "hasRole('ADMIN') && isAuthenticated()")

    @PostMapping(value = "/clientdetail/delete/{id}")
    public ResponseEntity<ClientDetailDTO> deleteClient(@PathVariable String id) throws Exception {
        return ResponseEntity.ok().body(clientDetailService.deleteClient(id));
    }
}
