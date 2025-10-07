package com.ohgiraffers.com.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService =commentService;
    }
    @GetMapping("/list")
    public String findCommentList(Model model){
        List<CommentDTO> commentDTOList = commentService.findAllComments();
        System.out.println("commentDTOList = " + commentDTOList);
        for(CommentDTO comments : commentDTOList){
            System.out.println("comments = " + comments);
        }
        System.out.println(commentDTOList);
        model.addAttribute("commentDTOList",commentDTOList);
        return "comment/list";
    }
    @GetMapping("/add")
    public void addComment(){}
    @GetMapping("/update")
    public void updateComment(){}
    @GetMapping("/delete")
    public void deleteComment(){}

    @PostMapping("/add")
    public String addComment(CommentDTO newCommentDTO, RedirectAttributes rttr){
        commentService.addNewComment(newCommentDTO);
        rttr.addFlashAttribute("successMessage", "댓글작성");
        return "redirect:/comment/list";
    }
    @PostMapping("/update")
    public String updateComment(CommentDTO updateCommentDTO, RedirectAttributes rttr){
        commentService.updateComment(updateCommentDTO);
        rttr.addFlashAttribute("successMessage", "댓글수정");
        return "redirect:/comment/list";
    }
    @PostMapping("/delete")
    public String deleteComment(CommentDTO deleteCommentDTO, RedirectAttributes rttr){
        commentService.deleteComment(deleteCommentDTO);
        rttr.addFlashAttribute("successMessage", "댓글삭제");
        return "redirect:/comment/list";
    }

}
