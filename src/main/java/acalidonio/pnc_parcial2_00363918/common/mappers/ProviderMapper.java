package acalidonio.pnc_parcial2_00363918.common.mappers;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ProviderResponse;
import acalidonio.pnc_parcial2_00363918.domain.entities.MagicProvider;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProviderMapper {
    public MagicProvider toProviderCreate(CreateProviderRequest request) {
        return MagicProvider.builder()
                .name(request.getName())
                .type(request.getType())
                .build();
    }
    public MagicProvider toProviderUpdate(CreateProviderRequest request, UUID id) {
        return MagicProvider.builder()
                .id(id)
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public ProviderResponse toDto(MagicProvider provider) {
        return ProviderResponse.builder()
                .id(provider.getId())
                .name(provider.getName())
                .type(provider.getType())
                .build();
    }
}
