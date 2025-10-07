package com.ohgiraffers.com.board;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService =boardService;
    }

    @GetMapping("/list")
    public String findBoardList(Model model){
        List<BoardDTO> boardDTOList = boardService.findAllBoards();
        System.out.println("boardDTOList = " + boardDTOList);
        for(BoardDTO boards : boardDTOList){
            System.out.println("boards = " + boards);
        }
        System.out.println(boardDTOList);
        model.addAttribute("boardDTOList",boardDTOList);
        return "board/list";
    }
    @GetMapping("/add")
    public void addBoard(){}
    @GetMapping("/update")
    public void updateBoard(){}
    @GetMapping("/delete")
    public void deleteBoard(){}


    @PostMapping("/add")
    public String addBoard(BoardDTO newBoardDTO, RedirectAttributes rttr){
        boardService.addNewBoard(newBoardDTO);
        rttr.addFlashAttribute("successMessage", "게시판생성");
        return "redirect:/board/list";
    }
    @PostMapping("/update")
    public String updateBoard(BoardDTO updateBoardDTO, RedirectAttributes rttr){
        boardService.updateBoard(updateBoardDTO);
        rttr.addFlashAttribute("successMessage","게시판수정");
        return "redirect:/board/list";
    }
    @PostMapping("/delete")
    public String deleteBoard(BoardDTO deleteBoardDTO, RedirectAttributes rttr){
        boardService.deleteBoard(deleteBoardDTO);
        rttr.addFlashAttribute("successMessage","게시판삭제");
        return "redirect:/board/list";
    }


}
