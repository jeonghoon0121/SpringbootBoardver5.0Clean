package com.ohgiraffers.com.comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
    public List<CommentDTO> findAllComments() {
        System.out.println(commentMapper.findAllComments());
        return commentMapper.findAllComments();
    }
    @Transactional
    public void addNewComment(CommentDTO newCommentDTO){
        newCommentDTO.setCreatedAt(java.time.LocalDateTime.now());
        commentMapper.addNewComment(newCommentDTO);}
    @Transactional
    public void updateComment(CommentDTO updateCommentDTO) {
        updateCommentDTO.setUpdatedAt(java.time.LocalDateTime.now());
        commentMapper.updateComment(updateCommentDTO);
    }
    @Transactional
    public void deleteComment(CommentDTO deleteCommentDTO) {
        commentMapper.deleteComment(deleteCommentDTO);
    }
}
