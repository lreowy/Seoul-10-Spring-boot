package com.ssafy.test.board.controller;

import com.ssafy.test.board.dto.request.BoardCreateRequest;
import com.ssafy.test.board.dto.request.BoardPatchRequest;
import com.ssafy.test.board.dto.response.BoardGetResponse;
import com.ssafy.test.board.dto.response.BoardPatchResponse;
import com.ssafy.test.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        boardService.createBoard(boardCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<BoardGetResponse> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoard(boardId));
    }

    @PatchMapping("/board/{boardId}")
    public ResponseEntity<BoardPatchResponse> patchBoard(@PathVariable Long boardId, @RequestBody BoardPatchRequest boardPatchRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.patchBoard(boardId, boardPatchRequest));
    }
}
