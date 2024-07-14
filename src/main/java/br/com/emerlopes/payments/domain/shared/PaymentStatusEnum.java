package br.com.emerlopes.payments.domain.shared;

import lombok.Getter;

import java.util.Random;

@Getter
public enum PaymentStatusEnum {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DENIED("DENIED");

    private String status;

    PaymentStatusEnum(
            final String status
    ) {
        this.status = status;
    }

    public static PaymentStatusEnum fromString(
            final String status
    ) {
        for (PaymentStatusEnum paymentStatusEnum : PaymentStatusEnum.values()) {
            if (paymentStatusEnum.status.equalsIgnoreCase(status)) {
                return paymentStatusEnum;
            }
        }
        return null;
    }

    public static PaymentStatusEnum getRandomStatus() {
        PaymentStatusEnum[] statuses = values();
        int randomIndex = new Random().nextInt(statuses.length);
        return statuses[randomIndex];
    }
}
