package acalidonio.pnc_parcial2_00363918.common.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueArticleNameValidator.class)
@Documented
public @interface UniqueArticleName {
    String message() default "Product name must be unique.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}