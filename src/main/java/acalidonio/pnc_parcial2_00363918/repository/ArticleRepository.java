package acalidonio.pnc_parcial2_00363918.repository;

import acalidonio.pnc_parcial2_00363918.domain.entities.MagicArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<MagicArticle, UUID> {
    boolean existsByNameIgnoreCase(String name);
}
