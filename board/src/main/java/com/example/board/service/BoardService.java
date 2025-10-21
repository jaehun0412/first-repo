package com.example.board.service;

import lombok.RequiredArgsConstructor;
import com.example.board.domain.Board;
import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.exception.BoardNotFoundException;
import com.example.board.exception.PasswordMismatchException;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    // 목록 조회
    public List<BoardResponseDto> getBoardList() {
        return StreamSupport
                .stream(boardRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Board::getId).reversed())
                .map(BoardResponseDto::from)
                .collect(Collectors.toList());
    }

    // 상세 조회
    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("해당 게시물이 존재하지 않습니다."));

        return BoardResponseDto.fromDetail(board);
    }

    // 글 등록
    @Transactional
    public Long createBoard(BoardRequestDto dto) {
        Board board = new Board(dto.getName(), dto.getTitle(), dto.getPassword(), dto.getContent());
        return boardRepository.save(board).getId();
    }

    // 글 수정
    @Transactional
    public void updateBoard(Long id, BoardRequestDto dto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("해당 게시물이 존재하지 않습니다."));

        boolean passwordCorrect = board.isPasswordCorrect(dto.getPassword());
        if (!passwordCorrect) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        board.update(dto.getName(), dto.getTitle(), dto.getContent());
        boardRepository.save(board);
    }

    // 글 삭제
    @Transactional
    public void deleteBoard(Long id, String password) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("해당 게시물이 존재하지 않습니다."));

        boolean passwordCorrect = board.isPasswordCorrect(password);
        if (!passwordCorrect) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        boardRepository.deleteById(id);
    }
}
