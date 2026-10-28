package com.thequiett.firstboard.task;

import jakarta.validation.constraints.Size;
import java.util.List;

public record TaskSearchRequest(
        @Size(max = 255) String keyword,
        List<String> statuses,
        List<String> priorities,
        List<String> labels) {
}
