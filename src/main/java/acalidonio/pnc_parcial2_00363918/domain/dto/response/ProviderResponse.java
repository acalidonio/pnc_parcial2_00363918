package acalidonio.pnc_parcial2_00363918.domain.dto.response;

import acalidonio.pnc_parcial2_00363918.common.Type;
import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderResponse {
    private UUID id;
    private String name;
    private Type type;
}
