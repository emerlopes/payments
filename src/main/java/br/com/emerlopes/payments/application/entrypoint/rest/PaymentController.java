package br.com.emerlopes.payments.application.entrypoint.rest;

import br.com.emerlopes.payments.application.entrypoint.rest.dto.PaymentRequestDTO;
import br.com.emerlopes.payments.application.shared.CustomResponseDTO;
import br.com.emerlopes.payments.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.payments.domain.usecase.ProcessPaymentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentController(
            final ProcessPaymentUseCase processPaymentUseCase
    ) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @PostMapping("/process/{orderId}")
    public ResponseEntity<?> processPayment(
            final @PathVariable Long orderId,
            final @RequestBody PaymentRequestDTO paymentRequestDTO
    ) {

        final var executionResponse = processPaymentUseCase.execute(
                PaymentDomainEntity.builder()
                        .orderId(orderId)
                        .paymentMethod(paymentRequestDTO.getPaymentMethod())
                        .amount(paymentRequestDTO.getAmount())
                        .build()

        );
        return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponseDTO<>().setData(executionResponse)
        );
    }
}
