package com.viettel.project.service.mapper;

import com.viettel.project.entity.ClientDetail;
import com.viettel.project.service.dto.ClientDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Objects;

@Mapper(uses = {}, componentModel = "spring")
public interface ClientDetailMapper extends EntityMapper<ClientDetail, ClientDetailDTO>{
    default ClientDetailDTO fromId(String id){
        ClientDetailDTO detailDTO = new ClientDetailDTO();
        if(Objects.isNull(id)) return null;
        detailDTO.setClientId(id);
        return detailDTO;
    }
}
