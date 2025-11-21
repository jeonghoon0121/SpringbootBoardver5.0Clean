package com.ohgiraffers.com.boardver5.model.controller;

import com.ohgiraffers.com.boardver5.service.BoardService;
import com.ohgiraffers.com.boardver5.model.dto.BoardDTO;
import com.ohgiraffers.com.boardver5.model.dto.CommentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/boardv5/comment")
public class CommentController {
    private final BoardService boardService;
    public CommentController(BoardService boardService) {
        this.boardService = boardService;
    }
    /*comment추가*/
    @GetMapping("/add/{postId}")
    public String showCommentAddForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);

        model.addAttribute("postId", postId);
        return "boardv5/commentAdd";
    }
    @PostMapping("/add/{postId}")
    public String handleCommentAdd(@PathVariable int postId,
                                   @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setPostId(postId);
        boardService.addNewComment(commentDTO);
        return "redirect:/boardv5/post/" + postId;
    }
        /*comment수정*/
    @PostMapping("/update/{commentId}")
    public String handleCommentUpdate(@PathVariable int commentId,
                                   @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setCommentId(commentId);
        int postId= boardService.findoneComment(commentId).getPostId();
        boardService.updateComment(commentDTO);
        return "redirect:/boardv5/post/" + postId;
    }
        /*comment삭제*/
    @PostMapping("/delete/{commentId}")
    public String handleCommentDelete(@PathVariable int commentId,
                                      @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setCommentId(commentId);
        int postId= boardService.findoneComment(commentId).getPostId();
        boardService.deleteComment(commentDTO);
        return "redirect:/boardv5/post/" + postId;
    }

    }