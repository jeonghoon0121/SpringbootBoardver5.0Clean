package com.ohgiraffers.com.post;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> findAllPosts();

    void addNewPost(PostDTO newPostDTO);
//    int updatePost(PostDTO updatePostDTO);
    void updatePost(PostDTO updatePostDTO);
    void deletePost(PostDTO deletePostDTO);
}
