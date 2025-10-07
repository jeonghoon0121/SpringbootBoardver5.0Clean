package com.ohgiraffers.com.boardver5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boardv5/post")
public class BV5PostController {
    private final BV5Service bv5Service;
    public BV5PostController(BV5Service bv5Service) {
        this.bv5Service = bv5Service;
    }
    @GetMapping("/add/{boardId}")
    public String showPostAddForm(@PathVariable int boardId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        model.addAttribute("boardlist",bv5DTOBoards );

        model.addAttribute("boardId", boardId);
        return "boardv5/postAdd";
    }
    @GetMapping("/update/{postId}")
    public String showPostUpdateForm(@PathVariable int postId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        model.addAttribute("boardlist",bv5DTOBoards );

        model.addAttribute("postId", postId);
        return "boardv5/postUpdate";
    }
    @GetMapping("/delete/{postId}")
    public String showPostDeleteForm(@PathVariable int postId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        model.addAttribute("boardlist",bv5DTOBoards );

        model.addAttribute("postId", postId);
        return "boardv5/postDelete";
    }
    /*post 더하기*/
    @PostMapping("/add/{boardId}")
    public String handlePostAdd(@PathVariable int boardId,
                                @ModelAttribute BV5DTOPost bv5DTOPost) {

        bv5DTOPost.setBoardId(boardId);
        bv5Service.addNewPost(bv5DTOPost);
        return "redirect:/boardv5/board/" + boardId;
    }
    /*post 수정*/
    @PostMapping("/update/{postId}")
    public String handlePostUpdate(@PathVariable int postId,
                                   @ModelAttribute BV5DTOPost bv5DTOPost) {
        bv5DTOPost.setPostId(postId);
        bv5Service.updatePost(bv5DTOPost);
        return "redirect:/boardv5/post/" + postId;
    }
    /*post 삭제*/
    @PostMapping("/delete/{postId}")
    public String handlePostDelete(@PathVariable int postId,
                                   @ModelAttribute BV5DTOPost bv5DTOPost) {
        bv5DTOPost.setPostId(postId);
        int boardId=bv5Service.findonePost(bv5DTOPost.getPostId()).getBoardId();
        bv5Service.deletePost(bv5DTOPost);
        return "redirect:/boardv5/board/"+boardId;
    }
}