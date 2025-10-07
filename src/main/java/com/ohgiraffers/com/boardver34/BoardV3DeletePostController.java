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
@RequestMapping("/boardv3/delete")
public class BoardV3DeletePostController {
    private final BoardV3Service boardV3Service;
    public BoardV3DeletePostController(BoardV3Service boardV3Service){this.boardV3Service=boardV3Service;}
    @GetMapping
    public String deletePostFormnull(Model model) {
        return "boardv3/delete";
    }
    @GetMapping("/{postId}")
    public String deletePostForm(@PathVariable int postId,Model model) {
        model.addAttribute("postId", postId);
        return "boardv3/delete";
    }

    @PostMapping("/{postId}")
    public String deletePost(@PathVariable int postId,
                             PostV3DTO deletePostV3DTO,
                             RedirectAttributes rttr) {
        deletePostV3DTO.setPostId(postId);
        boardV3Service.deletePost(deletePostV3DTO);
        rttr.addFlashAttribute("successMessage", "글이 삭제되었습니다.");
        return "redirect:/boardv3/list";
    }


}
