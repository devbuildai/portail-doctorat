package com.devbuild.common.dto;

import com.devbuild.common.enums.CandidatureStatus;
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
public class CandidatureDTO {
    private Long id;

    @NotNull(message = "L'identifiant du candidat est obligatoire")
    private Long candidatId;

    private String cvPath;

    private String lettreMotivationPath;

    @NotNull(message = "Le statut est obligatoire")
    private CandidatureStatus status; // EN_ATTENTE, ACCEPTEE, REJETEE

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
