package com.ssafy.test.board.dto.request;

//컨트롤러에서 넘겨받는 데이터 (게시물 작성 내용)
public record BoardCreateRequest(
        String title,
        String content,
        String author
) {
}
