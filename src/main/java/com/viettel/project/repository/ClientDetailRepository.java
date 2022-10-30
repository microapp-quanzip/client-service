package com.viettel.project.repository;

import com.viettel.project.entity.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDetailRepository extends JpaRepository<ClientDetail, String> {
}
