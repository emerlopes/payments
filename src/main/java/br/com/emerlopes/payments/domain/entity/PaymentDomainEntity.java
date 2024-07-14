package br.com.emerlopes.payments.domain.entity;

import br.com.emerlopes.payments.domain.shared.PaymentStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentDomainEntity {
    private Long paymentId;
    private Long orderId;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private PaymentStatusEnum status;
}
