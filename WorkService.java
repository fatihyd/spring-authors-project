package com.example.springauthorsproject.service;

import com.example.springauthorsproject.model.Work;
import com.example.springauthorsproject.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private final WorkRepository workRepository;

    @Autowired
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Transactional(readOnly = true)
    public List<Work> findWorksByAuthorId(Long authorId) {
        return workRepository.findByAuthorId(authorId);
    }

    @Transactional
    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    @Transactional(readOnly = true)
    public Optional<Work> findWorkById(Long id) {
        return workRepository.findById(id);
    }

    @Transactional
    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }
}
