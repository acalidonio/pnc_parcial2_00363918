package acalidonio.pnc_parcial2_00363918.domain.entities;

import acalidonio.pnc_parcial2_00363918.common.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "MagicArticle")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MagicArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Type type;
    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "magic_provider_id")
    private MagicProvider magicProvider;
}
