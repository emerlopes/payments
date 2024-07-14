package br.com.emerlopes.payments.domain.usecase;

import br.com.emerlopes.payments.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.payments.domain.shared.ExecuteArgs;

public interface ProcessPaymentUseCase extends ExecuteArgs<PaymentDomainEntity, PaymentDomainEntity> {
}
