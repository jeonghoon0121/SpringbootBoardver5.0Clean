package com.ohgiraffers.com.boardver5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/boardv5/comment")
public class BV5CommentController {
    private final BV5Service bv5Service;
    public BV5CommentController(BV5Service bv5Service) {
        this.bv5Service = bv5Service;
    }
    /*comment추가*/
    @GetMapping("/add/{postId}")
    public String showCommentAddForm(@PathVariable int postId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        model.addAttribute("boardlist",bv5DTOBoards );

        model.addAttribute("postId", postId);
        return "boardv5/commentAdd";
    }
    @PostMapping("/add/{postId}")
    public String handleCommentAdd(@PathVariable int postId,
                                   @ModelAttribute BV5DTOComment bv5DTOComment) {
        bv5DTOComment.setPostId(postId);
        bv5Service.addNewComment(bv5DTOComment);
        return "redirect:/boardv5/post/" + postId;
    }
        /*comment수정*/
    @PostMapping("/update/{commentId}")
    public String handleCommentUpdate(@PathVariable int commentId,
                                   @ModelAttribute BV5DTOComment bv5DTOComment) {
        bv5DTOComment.setCommentId(commentId);
        int postId=bv5Service.findoneComment(commentId).getPostId();
        bv5Service.updateComment(bv5DTOComment);
        return "redirect:/boardv5/post/" + postId;
    }
        /*comment삭제*/
    @PostMapping("/delete/{commentId}")
    public String handleCommentDelete(@PathVariable int commentId,
                                      @ModelAttribute BV5DTOComment bv5DTOComment) {
        bv5DTOComment.setCommentId(commentId);
        int postId=bv5Service.findoneComment(commentId).getPostId();
        bv5Service.deleteComment(bv5DTOComment);
        return "redirect:/boardv5/post/" + postId;
    }

    }