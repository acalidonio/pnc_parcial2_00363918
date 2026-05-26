package acalidonio.pnc_parcial2_00363918.service;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ArticleResponse;

import java.util.UUID;

public interface ArticleService {
    ArticleResponse getArticleById(UUID id);
    ArticleResponse createArticle(CreateArticleRequest request);
    ArticleResponse getAllArticles(String category, String provider, Float maxPrice);
    ArticleResponse updateArticle(UUID id, UpdateArticleRequest request);
    ArticleResponse deleteArticle(UUID id);
}
