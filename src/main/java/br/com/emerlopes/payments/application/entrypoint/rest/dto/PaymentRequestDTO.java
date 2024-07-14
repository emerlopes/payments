package br.com.emerlopes.payments.application.entrypoint.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentRequestDTO {
    private String paymentMethod;
    private BigDecimal amount;
}
