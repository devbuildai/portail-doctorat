package com.devbuild.common.dto;

import com.devbuild.common.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 3, max = 50, message = "Le prénom doit contenir entre 3 et 50 caractères")
    private String firstName;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères")
    private String lastName;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format email invalide")
    private String email;

    @NotBlank(message = "Le statut est obligatoire")
    private Status status;

    private Long equipeId; // Optionnel, obligatoire seulement pour DIRECTEUR_THESE

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
