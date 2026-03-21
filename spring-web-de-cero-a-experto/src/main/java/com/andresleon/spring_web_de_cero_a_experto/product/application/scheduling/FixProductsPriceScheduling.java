package com.andresleon.spring_web_de_cero_a_experto.product.application.scheduling;

import com.andresleon.spring_web_de_cero_a_experto.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductsPriceScheduling {

    private final ProductRepository productRepository;

    @Scheduled(fixedRate = 6000)
    public void fixProductsPriceScheduling() {
        log.info("Fixing products price");
        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice() * 1.1);
            productRepository.upset(product);
        });

        log.info("Finish fixing products price");
    }
}
