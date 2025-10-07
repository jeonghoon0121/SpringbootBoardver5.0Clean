package com.ohgiraffers.com.boardver31;

import com.ohgiraffers.com.boardver3.BoardV3DTO;
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
@RequestMapping("/boardv3/list")
public class BoardV3ListController {
    private final BoardV3Service boardV3Service;
    public BoardV3ListController(BoardV3Service boardV3Service) {
        this.boardV3Service = boardV3Service;
    }

    @GetMapping
    public String homeBoard(Model model) {
        List<BoardV3DTO> boardV3DTOs = boardV3Service.findAllBoards();
        List<PostV3DTO> postV3DTOs =boardV3Service.findAllPosts();
        List<CommentV3DTO> commentV3DTOs =boardV3Service.findAllComments();

        for (BoardV3DTO boards : boardV3DTOs) {
            System.out.println(boards);
        }
        for(PostV3DTO posts:postV3DTOs){
            System.out.println(posts);
        }
        for(CommentV3DTO comments:commentV3DTOs){
            System.out.println(comments);
        }
        model.addAttribute("boardV3DTOs", boardV3DTOs);
        model.addAttribute("postV3DTOs", postV3DTOs);
        model.addAttribute("commentV3DTOs", commentV3DTOs);
        return "boardv3/list";
    }
    @GetMapping("{boardId}")
    public String BoardList(@PathVariable int boardId,Model model) {
        List<PostV3DTO> postV3DTOs =boardV3Service.findAllPosts();
        List<PostV3DTO> filteredPosts = postV3DTOs.stream()
                .filter(post -> post.getBoardId() == boardId)
                .collect(Collectors.toList());
        model.addAttribute("postV3DTOs", filteredPosts);
        return "boardv3/board";
    }
}


