package acalidonio.pnc_parcial2_00363918.service;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ProviderResponse;

import java.util.UUID;

public interface ProviderService {
    ProviderResponse getProviderById(UUID id);
    ProviderResponse createProvider(CreateProviderRequest request);
    ProviderResponse updateProvider(UUID id, UpdateProviderRequest request);
    ProviderResponse deleteProvider(UUID id);
}
