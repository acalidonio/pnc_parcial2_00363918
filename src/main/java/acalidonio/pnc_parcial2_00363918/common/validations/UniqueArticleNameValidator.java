package acalidonio.pnc_parcial2_00363918.common.validations;

import acalidonio.pnc_parcial2_00363918.repository.ArticleRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueArticleNameValidator implements ConstraintValidator<UniqueArticleName, String> {
    private final ArticleRepository repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty())
            return true;

        return !repository.existsByNameIgnoreCase(value);
    }
}
