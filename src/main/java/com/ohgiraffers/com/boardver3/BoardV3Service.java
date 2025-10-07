package com.ohgiraffers.com.boardver3;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardV3Service {
    private final BoardV3Mapper boardV3Mapper;
    public BoardV3Service(BoardV3Mapper boardV3Mapper){
    this.boardV3Mapper=boardV3Mapper;
}
    public List<BoardV3DTO> findAllBoards() {
        return boardV3Mapper.findAllBoards();
    }
    public List<PostV3DTO> findAllPosts(){return boardV3Mapper.findAllPosts();}
    public List<CommentV3DTO> findAllComments(){return boardV3Mapper.findAllComments();}
    public BoardV3DTO findBoardById(int boardId){return boardV3Mapper.findOneBoard(boardId);}
    public PostV3DTO findPostById(int postId){return boardV3Mapper.findOnePost(postId);}
    public CommentV3DTO findCommentById(int commentId){return boardV3Mapper.findOneComment(commentId);}
    @Transactional
    public void addNewPost(PostV3DTO newPostV3DTO){
        newPostV3DTO.setCreatedAt(java.time.LocalDateTime.now());
        newPostV3DTO.setViewCount(0);
        boardV3Mapper.addNewPost(newPostV3DTO);
    }
    @Transactional
    public void addNewComment(CommentV3DTO newCommentV3DTO){
        newCommentV3DTO.setCreatedAt(java.time.LocalDateTime.now());
        boardV3Mapper.addNewComment(newCommentV3DTO);
    }
    @Transactional
    public void updatePost(PostV3DTO updatePostV3DTO) {
        updatePostV3DTO.setUpdatedAt(java.time.LocalDateTime.now());
        boardV3Mapper.updatePost(updatePostV3DTO);
    }
    @Transactional
    public void deletePost(PostV3DTO deletePostV3DTO) {
        boardV3Mapper.deletePost(deletePostV3DTO);
    }
    @Transactional
    public void updateComment(CommentV3DTO updateCommentV3DTO) {
        updateCommentV3DTO.setUpdatedAt(java.time.LocalDateTime.now());
        boardV3Mapper.updateComment(updateCommentV3DTO);
    }
    @Transactional
    public void deleteComment(CommentV3DTO deleteCommentV3DTO) {
        boardV3Mapper.deleteComment(deleteCommentV3DTO);
    }
}

