package com.ironhack.priceservice.service.implementations;

import com.ironhack.priceservice.controller.dto.PriceDTO;
import com.ironhack.priceservice.model.PriceEntity;
import com.ironhack.priceservice.repository.PriceRepository;
import com.ironhack.priceservice.service.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public PriceDTO findById(long id) {

        Optional<PriceEntity> optionalPriceEntity = priceRepository.findById(id);

        if (!optionalPriceEntity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exits");
        }

        PriceDTO priceDTO = new PriceDTO(optionalPriceEntity.get().getId(), optionalPriceEntity.get().getProductName(),
                optionalPriceEntity.get().getPrice());
        return priceDTO;


    }
}
