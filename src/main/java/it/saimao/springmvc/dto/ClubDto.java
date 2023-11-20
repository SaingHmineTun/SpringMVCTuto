package it.saimao.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClubDto {
    private Long id;
    @NotBlank
    @NotEmpty(message = "Title must not be empty")
    private String title;
    @NotBlank
    @NotEmpty(message = "Club photo must not be empty")
    private String photoUrl;
    @NotBlank
    @NotEmpty(message = "Club empty must not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
