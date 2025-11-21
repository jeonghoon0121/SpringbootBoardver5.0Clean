package com.ohgiraffers.com.boardver5.model.dao;

import com.ohgiraffers.com.boardver5.model.dto.BoardDTO;
import com.ohgiraffers.com.boardver5.model.dto.CommentDTO;
import com.ohgiraffers.com.boardver5.model.dto.PostDTO;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    List<BoardDTO> findAllBoards();
    List<PostDTO> findAllPosts();
    List<CommentDTO> findAllComments();
    BoardDTO findOneBoard(int boardId);
    PostDTO findOnePost(int postId);
    CommentDTO findOneComment(int commentId);

    void addNewPost(PostDTO postDTO);
    void updatePost(PostDTO postDTO);
    void deletePost(PostDTO postDTO);

    void addComment(CommentDTO commentDTO);
    void updateComment(CommentDTO commentDTO);
    void deleteComment(CommentDTO commentDTO);

}
