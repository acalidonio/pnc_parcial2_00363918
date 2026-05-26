package acalidonio.pnc_parcial2_00363918.repository;

import acalidonio.pnc_parcial2_00363918.domain.entities.MagicProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<MagicProvider, UUID> {
}
