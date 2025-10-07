package com.ohgiraffers.com.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/post/*")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService =postService;
    }

    @GetMapping("/list")
    public String findAllPosts(Model model){
        List<PostDTO> postDTOList = postService.findAllPosts();
//        System.out.println("postDTOList = " + postDTOList);
//        for(PostDTO posts : postDTOList){
//            System.out.println("posts = " + posts);
//        }
        model.addAttribute("postDTOList",postDTOList);
        return "post/list";
    }
    @GetMapping("/add")
    public void addPost(){}
    @GetMapping("/update")
    public void updatePost(){}
    @GetMapping("/delete")
    public void deletePost(){}

    @PostMapping("/add")
    public String addpost(PostDTO newPostDTO, RedirectAttributes rttr){
        postService.addNewPost(newPostDTO);
        rttr.addFlashAttribute("successMessage", "글작성");
        return "redirect:/post/list";
    }
    @PostMapping("/update")
    public String updatPost(PostDTO updatePostDTO, RedirectAttributes rttr){
        postService.updatePost(updatePostDTO);
        rttr.addFlashAttribute("successMessage","글수정");
        return "redirect:/post/list";
    }
    @PostMapping("/delete")
    public String deletePost(PostDTO deletePostDTO, RedirectAttributes rttr){
        postService.deletePost(deletePostDTO);
        rttr.addFlashAttribute("successMessage","글삭제");
        return "redirect:/post/list";
    }

}
