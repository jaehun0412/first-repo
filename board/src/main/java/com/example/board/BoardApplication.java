package com.example.board;

import com.example.board.controller.BoardController;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Autowired private BoardController controller;
    @Autowired private BoardService service;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Board Application Started!");

            service.getBoardList().forEach(System.out::println);

            System.out.println("==========================");
            System.out.println(service.getBoard(5L));
//            System.out.println(service.getBoard(15L));
        };
    }
}
