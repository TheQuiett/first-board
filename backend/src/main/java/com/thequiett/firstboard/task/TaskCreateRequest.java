package com.thequiett.firstboard.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TaskCreateRequest(
        @NotBlank @Size(max = 255) String title,
        @NotBlank @Pattern(regexp = "backlog|todo|in progress|done|canceled") String status,
        @NotBlank @Pattern(regexp = "bug|feature|documentation") String label,
        @NotBlank @Pattern(regexp = "low|medium|high") String priority) {
}
