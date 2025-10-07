package com.ohgiraffers.com.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostMapper postMapper;
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }
    public List<PostDTO> findAllPosts() {
        System.out.println(postMapper.findAllPosts());
        return postMapper.findAllPosts();

    }
    @Transactional
    public void addNewPost(PostDTO newPostDTO) {
        newPostDTO.setCreatedAt(java.time.LocalDateTime.now());
        newPostDTO.setViewCount(0);
        postMapper.addNewPost(newPostDTO);
    }
    @Transactional
    public void updatePost(PostDTO updatePostDTO) {
        updatePostDTO.setUpdatedAt(java.time.LocalDateTime.now());
        postMapper.updatePost(updatePostDTO);
//        int result=postMapper.updatePost(updatePostDTO);
//        System.out.println("test"+result);
    }
    @Transactional
    public void deletePost(PostDTO deletePostDTO) {
        postMapper.deletePost(deletePostDTO);
    }
}
