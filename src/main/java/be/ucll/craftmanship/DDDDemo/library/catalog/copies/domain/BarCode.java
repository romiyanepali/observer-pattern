package be.ucll.craftmanship.DDDDemo.library.catalog.copies.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

public record BarCode(
        @NotNull String code) {

    public BarCode {
        Assert.notNull(code, "code must not be null");
    }
}
