package com.ohgiraffers.com.board;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> findAllBoards();

    void addNewBoard(BoardDTO newBoardDTO);
    void updateBoard(BoardDTO updateBoardDTO);
    void deleteBoard(BoardDTO deleteBoardDTO);
}
