package com.devbuild.common.dto;

import com.devbuild.common.enums.InscriptionStatus;
import com.devbuild.common.enums.TypeInscription;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionDTO {
    private Long id;

    @NotNull(message = "L'identifiant du doctorant est obligatoire")
    private Long doctorantId;

    private Long candidatureId; // Optionnel

    @NotNull(message = "L'identifiant du directeur de thèse est obligatoire")
    private Long directeurTheseId;

    private Long coDirecteurTheseId; // Optionnel

    @NotBlank(message = "Le sujet de thèse est obligatoire")
    private String sujetThese;

    @NotNull(message = "L'année est obligatoire")
    @Min(value = 2025, message = "L'année doit être supérieure à 2025")
    private Integer year;

    @NotNull(message = "Le type d'inscription est obligatoire")
    private TypeInscription typeInscription;

    @NotNull(message = "Le statut est obligatoire")
    private InscriptionStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
