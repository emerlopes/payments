package br.com.emerlopes.payments.repository;

import br.com.emerlopes.payments.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.payments.domain.repository.PaymentDomainRepository;
import br.com.emerlopes.payments.domain.shared.PaymentStatusEnum;
import br.com.emerlopes.payments.infrastructure.database.entity.PaymentEntity;
import br.com.emerlopes.payments.infrastructure.database.repository.PaymentRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PaymentDomainRepositoryImpl implements PaymentDomainRepository {

    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(PaymentDomainRepositoryImpl.class);
    private final PaymentRepository paymentRepository;

    public PaymentDomainRepositoryImpl(
            final PaymentRepository paymentRepository
    ) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDomainEntity processPayment(
            final PaymentDomainEntity payment
    ) {

        final var paymentEntity = PaymentEntity.builder()
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .paymentDate(LocalDateTime.now())
                .status(PaymentStatusEnum.getRandomStatus().getStatus())
                .build();

        final var savedPayment = paymentRepository.save(paymentEntity);

        logger.info("Payment processed: {}", savedPayment.getPaymentId());

        return PaymentDomainEntity.builder()
                .paymentId(savedPayment.getPaymentId())
                .orderId(savedPayment.getOrderId())
                .paymentMethod(savedPayment.getPaymentMethod())
                .paymentDate(savedPayment.getPaymentDate())
                .amount(savedPayment.getAmount())
                .paymentDate(savedPayment.getPaymentDate())
                .status(PaymentStatusEnum.fromString(savedPayment.getStatus()))
                .build();
    }

}
