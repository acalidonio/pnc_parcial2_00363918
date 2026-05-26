package acalidonio.pnc_parcial2_00363918.domain.dto.response;

import acalidonio.pnc_parcial2_00363918.common.Type;
import acalidonio.pnc_parcial2_00363918.domain.entities.MagicProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {
    private UUID id;
    private String name;
    private Type type;
    private Float price;
    private MagicProvider magicProvider;
}
