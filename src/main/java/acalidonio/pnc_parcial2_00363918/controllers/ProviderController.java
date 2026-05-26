package acalidonio.pnc_parcial2_00363918.controllers;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateProviderRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.GeneralResponse;
import acalidonio.pnc_parcial2_00363918.service.impl.ProviderServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderServiceImpl service;

    @PostMapping
    public ResponseEntity<GeneralResponse> createProvider(
            @Valid @RequestBody CreateProviderRequest request
    ) {
        return buildResponse(
                "Provider created successfully",
                HttpStatus.CREATED,
                service.createProvider(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getProviderById(
            @PathVariable UUID id
    ) {
        return buildResponse(
                "Provider Found",
                HttpStatus.OK,
                service.getProviderById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateProvider(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProviderRequest request
    ) {
        return buildResponse(
                "Provider details updated successfully",
                HttpStatus.OK,
                service.updateProvider(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteProvider(
            @PathVariable UUID id
    ) {
        return buildResponse(
                "Provider deleted.",
                HttpStatus.OK,
                service.deleteProvider(id)
        );
    }


    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity.status(status).body(
                GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
        );
    }
}
