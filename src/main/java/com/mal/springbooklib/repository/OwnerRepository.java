package com.mal.springbooklib.repository;

import com.mal.springbooklib.model.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerModel, Long> {

}
