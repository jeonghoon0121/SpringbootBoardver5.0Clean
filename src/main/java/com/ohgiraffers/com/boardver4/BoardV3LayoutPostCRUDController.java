package com.ohgiraffers.com.boardver4;

import com.ohgiraffers.com.boardver3.BoardV3DTO;
import com.ohgiraffers.com.boardver3.BoardV3Service;
import com.ohgiraffers.com.boardver3.CommentV3DTO;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/layout/post")
public class BoardV3LayoutPostCRUDController {
    private final BoardV3Service boardV3Service;
    public BoardV3LayoutPostCRUDController(BoardV3Service boardV3Service){this.boardV3Service=boardV3Service;}


    @GetMapping("/{postId}")
    public String postDetail(@PathVariable int postId, Model model) {
        List<BoardV3DTO> boardV3DTOs = boardV3Service.findAllBoards();
        List<PostV3DTO> posts = boardV3Service.findAllPosts()
                .stream()
                .filter(p -> p.getPostId() == postId)
                .collect(Collectors.toList());
        List<CommentV3DTO> comments = boardV3Service.findAllComments()
                .stream()
                .filter(p -> p.getPostId() == postId)
                .collect(Collectors.toList());
        model.addAttribute("boardV3DTOs", boardV3DTOs);
        model.addAttribute("postV3DTOs", posts);
        model.addAttribute("commentV3DTOs", comments);
        return "layout/post-detail";
    }
    @GetMapping("/add/{boardId}")
    public String showAddPostForm(@PathVariable int boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "layout/post-add"; // 글 작성 폼 템플릿
    }
    @GetMapping("/update/{postId}")
    public String showUpdatePostForm(@PathVariable int postId, Model model) {
        model.addAttribute("postId", postId);
        return "layout/post-update";
    }
    @GetMapping("/delete/{postId}")
    public String showdeletePostForm(@PathVariable int postId,Model model) {
        model.addAttribute("postId", postId);
        return "layout/post-delete";
    }
    @GetMapping("/comment/update/{commentId}")
    public String showCommentUpdatePostForm(@PathVariable int commentId, Model model) {
        model.addAttribute("commentId", commentId);
        return "layout/comment-update";
    }
    @GetMapping("/comment/delete/{commentId}")
    public String showCommentDeletePostForm(@PathVariable int commentId, Model model) {
        model.addAttribute("commentId", commentId);
        return "layout/comment-delete";
    }

    @PostMapping("/add/{boardId}")
    public String addPost(@PathVariable int boardId, PostV3DTO newPostV3DTO, RedirectAttributes rttr){
        newPostV3DTO.setBoardId(boardId);
        boardV3Service.addNewPost(newPostV3DTO);
        rttr.addFlashAttribute("successMessage","글작성");
        return "redirect:/layout/"+boardId;
    }
    @PostMapping("/update/{postId}")
    public String updatePost(@PathVariable int postId,PostV3DTO updatePostV3DTO, RedirectAttributes rttr){
        updatePostV3DTO.setPostId(postId);
        boardV3Service.updatePost(updatePostV3DTO);
        rttr.addFlashAttribute("successMessage","글수정");
        return "redirect:/layout/home";
    }
    @PostMapping("/delete/{postId}")
    public String deletePost(@PathVariable int postId,
                             PostV3DTO deletePostV3DTO,
                             RedirectAttributes rttr) {
        deletePostV3DTO.setPostId(postId);
        boardV3Service.deletePost(deletePostV3DTO);
        rttr.addFlashAttribute("successMessage", "글이 삭제되었습니다.");
        return "redirect:/layout/home";
    }
    @PostMapping("/comment/add/{postId}")
    public String addComment(@PathVariable int postId,
                             CommentV3DTO newCommentV3DTO,
                             RedirectAttributes rttr) {
        newCommentV3DTO.setPostId(postId);
        boardV3Service.addNewComment(newCommentV3DTO);
        rttr.addFlashAttribute("successMessage", "댓글이 등록되었습니다.");
        return "redirect:/layout/post/" + postId;
    }

    @PostMapping("/comment/update/{commentId}")
    public String updateComment(@PathVariable int commentId,CommentV3DTO updateCommentV3DTO, RedirectAttributes rttr){
        updateCommentV3DTO.setCommentId(commentId);
        int postId=boardV3Service.findCommentById(updateCommentV3DTO.getCommentId()).getPostId();
        System.out.println("test"+postId);
        boardV3Service.updateComment(updateCommentV3DTO);
        return "redirect:/layout/post/"+postId;
    }
    @PostMapping("/comment/delete/{commentId}")
    public String deleteComment(@PathVariable int commentId, CommentV3DTO deleteCommentV3DTO, RedirectAttributes rttr) {
        deleteCommentV3DTO.setCommentId(commentId);
        int postId=boardV3Service.findCommentById(deleteCommentV3DTO.getCommentId()).getPostId();
        System.out.println("test"+postId);
        boardV3Service.deleteComment(deleteCommentV3DTO);
        return "redirect:/layout/post/"+postId;
    }


}


