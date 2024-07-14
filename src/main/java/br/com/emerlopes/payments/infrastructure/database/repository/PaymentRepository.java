package br.com.emerlopes.payments.infrastructure.database.repository;

import br.com.emerlopes.payments.infrastructure.database.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
