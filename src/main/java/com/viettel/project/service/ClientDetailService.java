package com.viettel.project.service;

import com.viettel.project.service.dto.ClientDetailDTO;

import java.util.List;

public interface ClientDetailService {
    ClientDetailDTO addClient(ClientDetailDTO clientDetailDTO) throws Exception;
    ClientDetailDTO deleteClient(String id) throws Exception;
    List<ClientDetailDTO> getAll();
}
