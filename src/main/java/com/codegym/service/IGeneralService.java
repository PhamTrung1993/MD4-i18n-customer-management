package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IGeneralService<T> {
    Iterable<T> findAll();
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);
    void save(T model);
    void delete(Long id);
}
