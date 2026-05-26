package acalidonio.pnc_parcial2_00363918.service.impl;

import acalidonio.pnc_parcial2_00363918.common.mappers.ProviderMapper;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ProviderResponse;
import acalidonio.pnc_parcial2_00363918.exceptions.ResourceNotFoundException;
import acalidonio.pnc_parcial2_00363918.repository.ProviderRepository;
import acalidonio.pnc_parcial2_00363918.service.ProviderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;
    private final ProviderMapper mapper;


    @Override
    public ProviderResponse getProviderById(UUID id) {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Provider not found"))
        );
    }

    @Override
    @Transactional
    public ProviderResponse createProvider(CreateProviderRequest request) {
        return null;
    }

    @Override
    @Transactional
    public ProviderResponse updateProvider(UUID id, UpdateProviderRequest request) {
        return null;
    }

    @Override
    @Transactional
    public ProviderResponse deleteProvider(UUID id) {
        return null;
    }
}
