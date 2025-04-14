package com.ssafy.test.board.dto.request;

public record BoardCreateRequest(
        String title,
        String content,
        String author
) {
}
