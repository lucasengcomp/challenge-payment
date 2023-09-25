package com.lucasengcomp.challengepayment.application.util;

import static com.lucasengcomp.challengepayment.application.util.Messages.ERROR_INSTANTIATED_CLASS;

public final class BigDecimalConstants {

    public static final int DEFAULT_SCALE_2 = 2;

    private BigDecimalConstants() {
        throw new AssertionError(ERROR_INSTANTIATED_CLASS);
    }
}
