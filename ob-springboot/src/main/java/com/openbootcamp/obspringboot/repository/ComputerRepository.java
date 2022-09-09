package com.openbootcamp.obspringboot.repository;

import com.openbootcamp.obspringboot.entity.ComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<ComputerEntity, Long> {
}
