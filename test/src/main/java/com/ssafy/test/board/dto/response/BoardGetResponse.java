package com.ssafy.test.board.dto.response;

import lombok.Builder;

@Builder
public record BoardGetResponse(
        Long id,
        String title,
        String content,
        String author
) {
}
