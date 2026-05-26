package acalidonio.pnc_parcial2_00363918.common.mappers;

import acalidonio.pnc_parcial2_00363918.domain.dto.request.CreateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.request.UpdateArticleRequest;
import acalidonio.pnc_parcial2_00363918.domain.dto.response.ArticleResponse;
import acalidonio.pnc_parcial2_00363918.domain.entities.MagicArticle;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ArticleMapper {
    public MagicArticle toArticleCreate(CreateArticleRequest request) {
        return MagicArticle.builder()
                .name(request.getName())
                .type(request.getType())
                .price(request.getPrice())
                .magicProvider(request.getMagicProvider())
                .build();
    }
    public MagicArticle toArticleUpdate(UpdateArticleRequest request, UUID id) {
        return MagicArticle.builder()
                .id(id)
                .name(request.getName())
                .type(request.getType())
                .price(request.getPrice())
                .magicProvider(request.getMagicProvider())
                .build();
    }

    public ArticleResponse toDto(MagicArticle article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .name(article.getName())
                .type(article.getType())
                .price(article.getPrice())
                .magicProvider(article.getMagicProvider())
                .build();
    }
}
