package com.andresleon.spring_web_de_cero_a_experto.IT;


import com.andresleon.spring_web_de_cero_a_experto.product.domain.entity.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.port.ProductRepository;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
@AutoConfigureMockMvc
public class ProductIt {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        productRepository.upset(new Product().builder()
                .id(1L)
                .name("Product 1")
                .description("Product 1 description")
                .price(100.0)
                .build());
        log.info("se agrego el producto 1");
    }


    @AfterEach
    void tearDown() {
        productRepository.deleteById(1L);
        log.info("se elimino el producto 1");
    }

    @Test
    public void getProductByIdCorrect() {
        ResponseEntity<ProductDto> response = restTemplate.getForEntity("/api/v1/products/1", ProductDto.class);

        log.info("conecto correctamente");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Product 1", response.getBody().getName());
        assertEquals("Product 1 description", response.getBody().getDescription());
        assertEquals(100.0, response.getBody().getPrice());
        log.info("se encontro y se recibio bien " + response.getBody().getName());
        log.info("verde");
        log.warn("amarillo");
        log.error("rojo");
        log.debug("azul");
    }

    @Test
    public void saveProduct() throws Exception {

        MockMultipartFile file = new MockMultipartFile("file", "image.jpeg", "image/jpeg", "image".getBytes());
        mockMvc.perform(
                multipart(HttpMethod.POST, "/api/v1/products")
                        .file(file)
                        .param("id", "2")
                        .param("name", "Product 2")
                        .param("description", "Product 2 description")
                        .param("price", "100.0")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpect(status().isCreated());
    }
}
