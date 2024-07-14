package br.com.emerlopes.payments.domain.repository;

import br.com.emerlopes.payments.domain.entity.PaymentDomainEntity;

public interface PaymentDomainRepository {
    PaymentDomainEntity processPayment(PaymentDomainEntity payment);
}
