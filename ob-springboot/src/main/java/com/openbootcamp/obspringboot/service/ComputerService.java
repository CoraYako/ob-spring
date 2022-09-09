package com.openbootcamp.obspringboot.service;

import com.openbootcamp.obspringboot.entity.ComputerEntity;

import java.util.List;

public interface ComputerService {

    ComputerEntity save(ComputerEntity entity);

    ComputerEntity update(Long id, ComputerEntity entity);

    ComputerEntity findById(Long id);

    void delete(Long id);

    List<ComputerEntity> getAll();
}
