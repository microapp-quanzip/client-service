package com.viettel.project.service.impl;

import com.viettel.project.entity.ClientDetail;
import com.viettel.project.repository.ClientDetailRepository;
import com.viettel.project.service.ClientDetailService;
import com.viettel.project.service.dto.ClientDetailDTO;
import com.viettel.project.service.mapper.ClientDetailMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientDetailServiceImpl implements ClientDetailService {

    @Autowired
    private ClientDetailRepository clientDetailRepository;

    @Autowired
    private ClientDetailMapper clientDetailMapper;

    @Override
    public ClientDetailDTO addClient(ClientDetailDTO clientDetailDTO) throws Exception {
        if(Objects.isNull(clientDetailDTO)){
            throw new Exception("Cannot add a null clientDetail");
        }
        ClientDetail clientDetail = new ClientDetail();
        BeanUtils.copyProperties(clientDetailDTO, clientDetail);
        clientDetail.setClientSecret(new BCryptPasswordEncoder().encode(clientDetail.getClientSecret()));
        clientDetailRepository.save(clientDetail);

        return clientDetailDTO;
    }

    @Override
    public ClientDetailDTO deleteClient(String id) throws Exception {
        if(Objects.isNull(id)){
            throw new Exception("Cannot delete a null ID");
        }
        ClientDetail clientDetail = clientDetailRepository.findById(id)
                .orElseThrow(()-> new Exception("cannot find ClientDetail By ID" + id));
        clientDetailRepository.deleteById(id);

        ClientDetailDTO clientDetailDTO = new ClientDetailDTO();
        BeanUtils.copyProperties(clientDetail, clientDetailDTO);
        return clientDetailDTO;
    }

    @Override
    public List<ClientDetailDTO> getAll() {
        return clientDetailMapper.toDTOs(clientDetailRepository.findAll());
    }
}
