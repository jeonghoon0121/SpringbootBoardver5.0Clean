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
@RequestMapping("/boardv3/update")
public class BoardV3UpdatePostController {
    private final BoardV3Service boardV3Service;
    public BoardV3UpdatePostController(BoardV3Service boardV3Service){this.boardV3Service=boardV3Service;}

    @GetMapping
    public String showUpdatePostForm( Model model) {
        return "boardv3/update";
    }

    @GetMapping("/{postId}")
    public String showAddPostForm(@PathVariable int postId, Model model) {
        model.addAttribute("postId", postId);
        return "boardv3/update"; // 글 작성 폼 템플릿
    }
    @PostMapping("/{postId}")
    public String updatePost(@PathVariable int postId,PostV3DTO updatePostV3DTO, RedirectAttributes rttr){
        updatePostV3DTO.setPostId(postId);
        boardV3Service.updatePost(updatePostV3DTO);
        rttr.addFlashAttribute("successMessage","글수정");
        return "redirect:/boardv3/list";}
}
