package com.andresleon.spring_web_de_cero_a_experto.product.application.query.getById;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
    private Long id;
}
