package com.upc.edu.pe.service.Impls;

import com.upc.edu.pe.entity.Promotion;
import com.upc.edu.pe.repository.PromotionRepository;
import com.upc.edu.pe.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    @Transactional
    @Override
    public Promotion save(Promotion entity) throws Exception {
        return promotionRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Promotion> findAll() throws Exception {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long aLong) throws Exception {
        return promotionRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Promotion update(Promotion entity) throws Exception {
        return promotionRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        promotionRepository.deleteById(aLong);

    }
}
