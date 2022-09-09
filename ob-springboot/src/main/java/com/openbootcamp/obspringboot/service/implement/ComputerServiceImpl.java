package com.openbootcamp.obspringboot.service.implement;

import com.openbootcamp.obspringboot.entity.ComputerEntity;
import com.openbootcamp.obspringboot.repository.ComputerRepository;
import com.openbootcamp.obspringboot.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository repository;

    @Autowired
    public ComputerServiceImpl(ComputerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public ComputerEntity save(ComputerEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public ComputerEntity update(Long id, ComputerEntity entity) {
        ComputerEntity entityFound = findById(id);

        if (entity.getCpu() != null && !entity.getCpu().trim().isEmpty())
            entityFound.setCpu(entity.getCpu());

        if (entity.getRam() != null && entity.getRam() > 0)
            entityFound.setRam(entity.getRam());

        if (entity.getGpu() != null && !entity.getGpu().trim().isEmpty())
            entityFound.setGpu(entity.getGpu());

        return repository.save(entityFound);
    }

    @Override
    @Transactional(readOnly = true)
    public ComputerEntity findById(Long id) {
        Optional<ComputerEntity> response = repository.findById(id);
        if (response.isEmpty())
            throw new NoSuchElementException("The ID is wrong or the computer doesn't exist.");
        else
            return response.get();
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public void delete(Long id) {
        repository.delete(
                findById(id)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ComputerEntity> getAll() {
        return repository.findAll();
    }
}
