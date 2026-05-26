package acalidonio.pnc_parcial2_00363918.domain.entities;

import acalidonio.pnc_parcial2_00363918.common.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "MagicProvider")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MagicProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Type type;
}
