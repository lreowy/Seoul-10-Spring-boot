package com.ssafy.test.board.dto.response;

import lombok.Builder;

@Builder
public record BoardPatchResponse(
        String title,
        String content,
        String author
) {
}
