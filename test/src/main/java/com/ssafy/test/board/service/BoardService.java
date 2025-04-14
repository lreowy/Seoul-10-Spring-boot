package com.ssafy.test.board.service;

import com.ssafy.test.board.domain.Board;
import com.ssafy.test.board.dto.request.BoardCreateRequest;
import com.ssafy.test.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(BoardCreateRequest boardCreateRequest) {
        Board board = Board.builder()
                .title(boardCreateRequest.title())
                .content(boardCreateRequest.content())
                .author(boardCreateRequest.author())
                .build();
        boardRepository.save(board);
    }
}
