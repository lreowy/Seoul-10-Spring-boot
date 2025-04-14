package com.ssafy.test.board.dto.request;

public record BoardPatchRequest(
        String title,
        String content,
        String author
) {
}
