package acalidonio.pnc_parcial2_00363918.domain.dto.request;

import acalidonio.pnc_parcial2_00363918.common.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProviderRequest {
    @NotBlank(message = "Provider should not be empty.")
    private String name;

    @NotBlank(message = "Type should not be empty.")
    private Type type;
}
