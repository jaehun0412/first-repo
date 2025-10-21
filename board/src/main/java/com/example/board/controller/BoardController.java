package com.example.board.controller;

import com.example.board.exception.PasswordMismatchException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 목록 조회
    @GetMapping("/list")
    public String getBoardList(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/list";
    }

    // 상세 조회
    @GetMapping("/view/{id}")
    public String getBoard(@PathVariable("id") Long id, Model model) {
        BoardResponseDto board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board/view";
    }

    // 작성 폼
    @GetMapping("/writeform")
    public String getWriteForm(Model model) {
        model.addAttribute("board", new BoardRequestDto());
        return "board/writeform";
    }

    // 글 등록
    @PostMapping("/write")
    public String writeBoard(@Valid @ModelAttribute BoardRequestDto requestDto,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "board/writeform";
        }
        Long id = boardService.createBoard(requestDto);

        return "redirect:/board/view/" + id;
    }

    // 수정 폼
    @GetMapping("/updateform/{id}")
    public String getUpdateForm(@PathVariable("id") Long id, Model model) {
        BoardResponseDto board = boardService.getBoard(id);

        BoardRequestDto requestDto = new BoardRequestDto();
        requestDto.setName(board.getName());
        requestDto.setTitle(board.getTitle());
        requestDto.setContent(board.getContent());

        model.addAttribute("board", requestDto);
        model.addAttribute("boardId", board.getId());

        return "board/updateform";
    }

    // 글 수정
    @PostMapping("/update")
    public String updateBoard(@RequestParam("id") Long id,
                              @Valid @ModelAttribute BoardRequestDto requestDto,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("boardId", id);
            return "board/updateform";
        }

        try {
            boardService.updateBoard(id, requestDto);
            return "redirect:/board/view/" + id;
        } catch (PasswordMismatchException e) {
            model.addAttribute("boardId", id);
            model.addAttribute("errorMessage", e.getMessage());
            return "board/updateform";
        }
    }

    // 삭제 폼
    @GetMapping("/deleteform/{id}")
    public String getDeleteForm(@PathVariable("id") Long id, Model model) {
        BoardResponseDto board = boardService.getBoard(id);
        model.addAttribute("boardId", board.getId());
        return "board/deleteform";
    }

    // 글 삭제
    @PostMapping("/delete")
    public String deleteBoard(@RequestParam("id") Long id,
                              @RequestParam("password") String password,
                              Model model) {

        try {
            boardService.deleteBoard(id, password);
            return "redirect:/board/list";
        } catch (PasswordMismatchException e) {
            model.addAttribute("boardId", id);
            model.addAttribute("errorMessage", e.getMessage());
            return "board/deleteform";
        }
    }
}
