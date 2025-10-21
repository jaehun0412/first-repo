package com.example.board.dto;

import lombok.Builder;
import lombok.Data;
import com.example.board.domain.Board;

import java.time.format.DateTimeFormatter;

@Data
@Builder
public class BoardResponseDto {

    private Long id;
    private String name;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    public static BoardResponseDto from(Board board) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt().format(formatter))
                .updatedAt(board.getUpdatedAt().format(formatter))
                .build();
    }

    public static BoardResponseDto fromDetail(Board board) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt().format(formatter))
                .updatedAt(board.getUpdatedAt().format(formatter))
                .build();
    }
}
