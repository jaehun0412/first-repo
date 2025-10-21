package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Board(String name, String title, String password, String content) {
        this.name = name;
        this.title = title;
        this.password = password;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isPasswordCorrect(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void update(String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }
}
