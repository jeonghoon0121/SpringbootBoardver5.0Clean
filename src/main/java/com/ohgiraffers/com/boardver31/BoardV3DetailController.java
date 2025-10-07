package com.ohgiraffers.com.boardver31;

import com.ohgiraffers.com.boardver3.BoardV3Service;
import com.ohgiraffers.com.boardver3.CommentV3DTO;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/boardv3/detail")
public class BoardV3DetailController {
    private final BoardV3Service boardV3Service;
    public BoardV3DetailController(BoardV3Service boardV3Service) {
        this.boardV3Service = boardV3Service;
    }

    @GetMapping
    public String homeBoard(Model model) {
        List<PostV3DTO> postV3DTOs =boardV3Service.findAllPosts();
        List<CommentV3DTO> commentV3DTOs =boardV3Service.findAllComments();
        model.addAttribute("postV3DTOs", postV3DTOs);
        model.addAttribute("commentV3DTOs", commentV3DTOs);
        return "boardv3/detail";
    }
    @GetMapping("/{postId}")
    public String postDetail(@PathVariable int postId, Model model) {
        List<CommentV3DTO> filteredComments = boardV3Service.findAllComments().stream()
                .filter(comment -> comment.getPostId() == postId)
                .collect(Collectors.toList());
        List<PostV3DTO> postV3DTOs =boardV3Service.findAllPosts().stream()
                .filter(post -> post.getPostId() == postId)
                .collect(Collectors.toList());
        model.addAttribute("commentV3DTOs", filteredComments);
        model.addAttribute("postV3DTOs", postV3DTOs);// 뷰에서 사용 가능
        return "boardv3/detail/post";
    }



}


