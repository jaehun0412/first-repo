package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardRequestDto {

    @NotBlank(message = "이름을 작성해주세요.") @Size(max = 20, message = "이름이 너무 깁니다.")
    private String name;
    @NotBlank(message = "제목을 작성해주세요.") @Size(max = 50, message = "제목이 너무 깁니다.")
    private String title;
    @NotBlank(message = "암호를 작성해주세요.")
    @Size(min = 4, max = 10, message = "비밀번호는 4 ~ 10자리 입니다.")
    private String password;
    @NotBlank(message = "내용을 작성해주세요.") private String content;
}
