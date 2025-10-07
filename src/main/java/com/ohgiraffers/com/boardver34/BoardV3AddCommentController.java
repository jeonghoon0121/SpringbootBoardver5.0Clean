package com.ohgiraffers.com.boardver34;

import com.ohgiraffers.com.boardver3.BoardV3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardv3/add2")
public class BoardV3AddCommentController {
    private final BoardV3Service boardV3Service;
    public BoardV3AddCommentController(BoardV3Service boardV3Service){this.boardV3Service=boardV3Service;}
    @GetMapping
    public String showAddCommentForm( Model model) {
        return "boardv3/add2";
    }

}