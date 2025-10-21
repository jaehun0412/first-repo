package com.example.board.repository;

import com.example.board.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    // 기본 메서드 제공: save(), findById(), findAll(), deleteById(), count()

    // 추가 메서드 작성 (선택사항)
    // TODO: findByTitle()
    List<Board> findByName(String name);

    // TODO: findByName()
    List<Board> findByTitle(String title);
}
