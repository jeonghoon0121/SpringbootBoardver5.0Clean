package com.ohgiraffers.com.boardver5.service;
import com.ohgiraffers.com.boardver5.model.dao.Mapper;
import com.ohgiraffers.com.boardver5.model.dto.BoardDTO;
import com.ohgiraffers.com.boardver5.model.dto.CommentDTO;
import com.ohgiraffers.com.boardver5.model.dto.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final Mapper mapper;
    public BoardService(Mapper mapper){
    this.mapper = mapper;
}

    public List<BoardDTO> findAllBoards(){return mapper.findAllBoards();}
    public List<PostDTO> findAllPosts(){return mapper.findAllPosts();}
    public List<CommentDTO> findAllComments(){return mapper.findAllComments();}
    public List<PostDTO> findPostsByBoardId(int boardId) {
        List<PostDTO> result = new ArrayList<>();
        for (PostDTO post : findAllPosts()) {
            if (post.getBoardId() == boardId) {
                result.add(post);
            }
        }
        return result;
    }
    public List<CommentDTO> findCommentsByPostId(int postId) {
        List<CommentDTO> result = new ArrayList<>();
        for (CommentDTO comment : findAllComments()) {
            if (comment.getPostId() == postId) {
                result.add(comment);
            }
        }
        return result;
    }

    public BoardDTO findoneBoard(int boardId) {
        return mapper.findOneBoard(boardId);
    }

    public PostDTO findonePost(int postId) {
        return mapper.findOnePost(postId);
    }
    public CommentDTO findoneComment(int commentId){
        return mapper.findOneComment(commentId);
    }
    @Transactional
    public void addNewPost(PostDTO postDTO){
        postDTO.setCreatedAt(java.time.LocalDateTime.now());
        postDTO.setUpdatedAt(java.time.LocalDateTime.now());
        postDTO.setViewCount(0);
        mapper.addNewPost(postDTO);
    }
    @Transactional
    public void updatePost(PostDTO postDTO) {
        postDTO.setUpdatedAt(java.time.LocalDateTime.now());
        mapper.updatePost(postDTO);
    }
    @Transactional
    public void deletePost(PostDTO postDTO) {
        mapper.deletePost(postDTO);
    }
    @Transactional
    public void addNewComment(CommentDTO commentDTO){
        commentDTO.setCreatedAt(java.time.LocalDateTime.now());
        commentDTO.setUpdatedAt(java.time.LocalDateTime.now());

        mapper.addComment(commentDTO);
    }
    @Transactional
    public void updateComment(CommentDTO commentDTO) {
        commentDTO.setUpdatedAt(java.time.LocalDateTime.now());
        mapper.updateComment(commentDTO);
    }
    @Transactional
    public void deleteComment(CommentDTO commentDTO) {
        mapper.deleteComment(commentDTO);
    }
}

