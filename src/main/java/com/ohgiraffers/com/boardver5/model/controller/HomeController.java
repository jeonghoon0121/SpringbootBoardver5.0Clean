package com.ohgiraffers.com.boardver5.model.controller;

import com.ohgiraffers.com.boardver5.service.BoardService;
import com.ohgiraffers.com.boardver5.model.dto.BoardDTO;
import com.ohgiraffers.com.boardver5.model.dto.CommentDTO;
import com.ohgiraffers.com.boardver5.model.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("")
public class HomeController {
    private final BoardService boardService;

    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping({"", "/", "/home", "/home/"})
    public String BoardHome(Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        List<PostDTO> postDTOS = boardService.findAllPosts();
        List<CommentDTO> commentDTOS = boardService.findAllComments();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("postlist", postDTOS);
        model.addAttribute("commentlist", commentDTOS);
        return "home";
    }

    @GetMapping("test")
    public String TestHomeBoard() {
        return "index";
    }

    @GetMapping("board/{boardId}")
    public String getBoardList(@PathVariable int boardId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        BoardDTO board = boardService.findoneBoard(boardId);
        List<PostDTO> posts = boardService.findPostsByBoardId(boardId);

        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("board", board);
        model.addAttribute("postlist", posts);
        return "boardlist";
    }

    @GetMapping("post/{postId}")
    public String getPostDetail(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        PostDTO post = boardService.findonePost(postId);
        List<CommentDTO> comments = boardService.findCommentsByPostId(postId);

        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("post", post);
        model.addAttribute("commentlist", comments);
        return "postDetail";
    }


}


