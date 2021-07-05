package com.upc.edu.pe.service.Impls;

import com.upc.edu.pe.entity.Disccount;
import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.repository.DisccountRepository;
import com.upc.edu.pe.service.DisccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DisccountServiceImpl implements DisccountService {

    @Autowired
    private DisccountRepository disccountRepository;

    @Transactional
    @Override
    public Disccount save(Disccount entity) throws Exception {
        return disccountRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Disccount> findAll() throws Exception {

        return disccountRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Disccount> findById(Long aLong) throws Exception {
        return disccountRepository.findById(aLong);
    }
    @Transactional
    @Override
    public Disccount update(Disccount entity) throws Exception {
        return disccountRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        disccountRepository.deleteById(aLong);

    }

    @Override
    public Disccount getDisccountById(Long menuId) {
        return disccountRepository.findById(menuId).orElseThrow(()->new ResourceNotFoundException("Disscount","Id",menuId));
    }
}
