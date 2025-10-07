package com.ohgiraffers.com.comment;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDTO> findAllComments();
    void addNewComment(CommentDTO newCommentDTO);
    void updateComment(CommentDTO updateCommentDTO);
    void deleteComment(CommentDTO deleteCommentDTO);
}
