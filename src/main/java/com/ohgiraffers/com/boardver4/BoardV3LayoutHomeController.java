package com.ohgiraffers.com.boardver4;

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
@RequestMapping("/layout")
public class BoardV3LayoutHomeController {
    private final BoardV3Service boardV3Service;
    public BoardV3LayoutHomeController(BoardV3Service boardV3Service) {
        this.boardV3Service = boardV3Service;
    }
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/layout/home";
    }

    @GetMapping("/home")
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
        return "layout/home";
    }
    @GetMapping("/home1")
    public String homeBoard1(Model model) {
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
        return "layout/home1";
    }
    @GetMapping("/home2")
    public String homeBoard2(Model model) {
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
        return "layout/home2";
    }
    @GetMapping("/home3")
    public String homeBoard3(Model model) {
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
        return "layout/home3";
    }

    @GetMapping("/home4")
    public String homeBoard4(Model model) {
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
        return "layout/home4";
    }
    @GetMapping("/{boardId}")
    public String boardDetail(@PathVariable int boardId, Model model) {
        List<BoardV3DTO> boardV3DTOs = boardV3Service.findAllBoards();
        List<PostV3DTO> posts = boardV3Service.findAllPosts()
                .stream()
                .filter(p -> p.getBoardId() == boardId)
                .collect(Collectors.toList());
        model.addAttribute("boardV3DTOs", boardV3DTOs);
        model.addAttribute("postV3DTOs", posts);
        model.addAttribute("boardId", boardId);
        return "layout/board-detail";
    }
    @GetMapping("/test/{boardId}")
    public String boardDetailTest(@PathVariable int boardId, Model model) {
        List<BoardV3DTO> boardV3DTOs = boardV3Service.findAllBoards();
        List<PostV3DTO> posts = boardV3Service.findAllPosts()
                .stream()
                .filter(p -> p.getBoardId() == boardId)
                .collect(Collectors.toList());
        model.addAttribute("boardV3DTOs", boardV3DTOs);
        model.addAttribute("postV3DTOs", posts);
        model.addAttribute("boardId", boardId);
        return "layout/board-detail2";
    }
//    @GetMapping("/post/{postId}")
//    public String postDetail(@PathVariable int postId, Model model) {
//        List<BoardV3DTO> boardV3DTOs = boardV3Service.findAllBoards();
//        List<PostV3DTO> posts = boardV3Service.findAllPosts()
//                .stream()
//                .filter(p -> p.getPostId() == postId)
//                .collect(Collectors.toList());
//        List<CommentV3DTO> comments = boardV3Service.findAllComments()
//                .stream()
//                .filter(p -> p.getPostId() == postId)
//                .collect(Collectors.toList());
//        model.addAttribute("boardV3DTOs", boardV3DTOs);
//        model.addAttribute("postV3DTOs", posts);
//        model.addAttribute("commentV3DTOs", comments);
//        return "layout/post-detail";
//    }

}
