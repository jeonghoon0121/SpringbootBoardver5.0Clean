package com.ohgiraffers.com.boardver5.model.controller;

import com.ohgiraffers.com.boardver5.service.BoardService;
import com.ohgiraffers.com.boardver5.model.dto.BoardDTO;
import com.ohgiraffers.com.boardver5.model.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final BoardService boardService;
    public PostController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/add/{boardId}")
    public String showPostAddForm(@PathVariable int boardId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);

        model.addAttribute("boardId", boardId);
        return "postAdd";
    }
    @GetMapping("/update/{postId}")
    public String showPostUpdateForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);

        model.addAttribute("postId", postId);
        return "postUpdate";
    }
    @GetMapping("/delete/{postId}")
    public String showPostDeleteForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);

        model.addAttribute("postId", postId);
        return "postDelete";
    }
    /*post 더하기*/
    @PostMapping("/add/{boardId}")
    public String handlePostAdd(@PathVariable int boardId,
                                @ModelAttribute PostDTO postDTO) {

        postDTO.setBoardId(boardId);
        boardService.addNewPost(postDTO);
        return "redirect:/board/" + boardId;
    }
    /*post 수정*/
    @PostMapping("/update/{postId}")
    public String handlePostUpdate(@PathVariable int postId,
                                   @ModelAttribute PostDTO postDTO) {
        postDTO.setPostId(postId);
        boardService.updatePost(postDTO);
        return "redirect:/post/" + postId;
    }
    /*post 삭제*/
    @PostMapping("/delete/{postId}")
    public String handlePostDelete(@PathVariable int postId,
                                   @ModelAttribute PostDTO postDTO) {
        postDTO.setPostId(postId);
        int boardId= boardService.findonePost(postDTO.getPostId()).getBoardId();
        boardService.deletePost(postDTO);
        return "redirect:/board/"+boardId;
    }
}