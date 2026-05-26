package acalidonio.pnc_parcial2_00363918.domain.dto.request;

import acalidonio.pnc_parcial2_00363918.common.Type;
import acalidonio.pnc_parcial2_00363918.common.validations.UniqueArticleName;
import acalidonio.pnc_parcial2_00363918.domain.entities.MagicProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleRequest {
    @NotBlank(message = "Name should not be blank.")
    @UniqueArticleName
    private String name;
    @NotBlank(message = "Type should not be blank.")
    private Type type;
    @NotNull(message = "Price must not be null.")
    @Positive(message = "Price must be higher than 0")
    private Float price;
    @NotNull(message = "Provider is required")
    private MagicProvider magicProvider;
}
