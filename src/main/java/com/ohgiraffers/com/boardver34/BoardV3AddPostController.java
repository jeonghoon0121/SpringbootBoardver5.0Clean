package com.ohgiraffers.com.boardver34;

import com.ohgiraffers.com.boardver3.BoardV3Service;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/boardv3/add")
public class BoardV3AddPostController {
    private final BoardV3Service boardV3Service;
    public BoardV3AddPostController(BoardV3Service boardV3Service){this.boardV3Service=boardV3Service;}

    @GetMapping
    public String showAddPostForm( Model model) {
        return "boardv3/add";
    }
    @GetMapping("/{boardId}")
    public String showAddPostForm(@PathVariable int boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "boardv3/add"; // 글 작성 폼 템플릿
    }

    @PostMapping("/{boardId}")
    public String addPost(@PathVariable int boardId, PostV3DTO newPostV3DTO, RedirectAttributes rttr){
        boardV3Service.addNewPost(newPostV3DTO);
        rttr.addFlashAttribute("successMessage","글작성");
        return "redirect:/boardv3/list/"+boardId;
    }
}
