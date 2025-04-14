package com.ssafy.test.board.service;

import com.ssafy.test.board.domain.Board;
import com.ssafy.test.board.dto.request.BoardCreateRequest;
import com.ssafy.test.board.dto.request.BoardPatchRequest;
import com.ssafy.test.board.dto.response.BoardGetResponse;
import com.ssafy.test.board.dto.response.BoardPatchResponse;
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

    public BoardGetResponse getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("해당 게시물이 존재하지 않습니다."));
        return BoardGetResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .build();
    }

    public BoardPatchResponse patchBoard(Long boardId, BoardPatchRequest boardPatchRequest) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow( () -> new RuntimeException("해당 게시물이 존재하지 않습니다."));
        board.updateBoard(boardPatchRequest.title(),
                boardPatchRequest.content(),
                boardPatchRequest.author());
        boardRepository.save(board);
        return BoardPatchResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .build();
    }
}
