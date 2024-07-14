package br.com.emerlopes.payments.domain.usecase.impl;

import br.com.emerlopes.payments.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.payments.domain.repository.PaymentDomainRepository;
import br.com.emerlopes.payments.domain.usecase.ProcessPaymentUseCase;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentUseCaseImpl implements ProcessPaymentUseCase {

    private final PaymentDomainRepository paymentDomainRepository;

    public ProcessPaymentUseCaseImpl(
            final PaymentDomainRepository paymentDomainRepository
    ) {
        this.paymentDomainRepository = paymentDomainRepository;
    }

    @Override
    public PaymentDomainEntity execute(
            final PaymentDomainEntity paymentDomainEntity
    ) {
        return paymentDomainRepository.processPayment(paymentDomainEntity);
    }
}
