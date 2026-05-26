package acalidonio.pnc_parcial2_00363918.controllers;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.GeneralResponse;
import acalidonio.pnc_parcial2_00363918.service.impl.ArticleServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/artefacts")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleServiceImpl service;

    @GetMapping
    public ResponseEntity<GeneralResponse> getArticles(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String provider,
            @RequestParam(required = false) Float maxPrice
    ) {
        return buildResponse(
                "Articles retrieved successfully",
                HttpStatus.OK,
                service.getAllArticles(category, provider, maxPrice)
        );
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> createArticle(
            @Valid @RequestBody CreateArticleRequest request
    ) {
        return buildResponse(
                "Article created successfully",
                HttpStatus.CREATED,
                service.createArticle(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getArticleById(
            @PathVariable UUID id
    ) {
        return buildResponse(
                "Article Found",
                HttpStatus.OK,
                service.getArticleById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateArticle(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateArticleRequest request
    ) {
        return buildResponse(
                "Article details updated successfully",
                HttpStatus.OK,
                service.updateArticle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteProvider(
            @PathVariable UUID id
    ) {
        return buildResponse(
                "Article deleted.",
                HttpStatus.OK,
                service.deleteArticle(id)
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
