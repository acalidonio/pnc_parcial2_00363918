package acalidonio.pnc_parcial2_00363918.service.impl;

import acalidonio.pnc_parcial2_00363918.common.mappers.ArticleMapper;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ArticleResponse;
import acalidonio.pnc_parcial2_00363918.domain.entities.MagicArticle;
import acalidonio.pnc_parcial2_00363918.exceptions.ResourceNotFoundException;
import acalidonio.pnc_parcial2_00363918.repository.ArticleRepository;
import acalidonio.pnc_parcial2_00363918.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repository;
    private final ArticleMapper mapper;


    @Override
    public ArticleResponse getArticleById(UUID id) {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Article not found"))
        );
    }

    @Override
    public ArticleResponse createArticle(CreateArticleRequest request) {
        MagicArticle article = mapper.toArticleCreate(request);

        return mapper.toDto(repository.save(article));
    }

    @Override
    public ArticleResponse getAllArticles(String category, String provider, Float maxPrice) {
        return null;
    }

    @Override
    public ArticleResponse updateArticle(UUID id, UpdateArticleRequest request) {
        this.getArticleById(id);
        return mapper.toDto(repository.save(mapper.toArticleUpdate(request, id)));
    }

    @Override
    public ArticleResponse deleteArticle(UUID id) {
        ArticleResponse article = this.getArticleById(id);

        /*if (provider.getCategory() == Product.Category.INGREDIENT && product.getAvailable()) {
            throw new ConflictException("Provider cannot be eliminated as it still has available products");
        }*/

        repository.deleteById(id);
        return article;
    }
}
