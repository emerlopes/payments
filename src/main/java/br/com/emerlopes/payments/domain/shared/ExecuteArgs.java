package br.com.emerlopes.payments.domain.shared;

public interface ExecuteArgs<T, J> {
    T execute(J domainObject);
}
