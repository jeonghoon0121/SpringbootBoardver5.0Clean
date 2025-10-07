package com.ohgiraffers.com.board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDTO> findAllBoards() {
        System.out.println(boardMapper.findAllBoards());
        return boardMapper.findAllBoards();

    }
    @Transactional
    public void addNewBoard(BoardDTO newBoardDTO) {
        boardMapper.addNewBoard(newBoardDTO);

    }
    public void updateBoard(BoardDTO updateBoardDTO) {
        boardMapper.updateBoard(updateBoardDTO);
    }

    public void deleteBoard(BoardDTO deleteBoardDTO) {
        boardMapper.deleteBoard(deleteBoardDTO);
    }
}
