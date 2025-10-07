package com.ohgiraffers.com.boardver5;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BV5Service {
    private final BV5Mapper bv5Mapper;
    public BV5Service(BV5Mapper bv5Mapper){
    this.bv5Mapper=bv5Mapper;
}

    public List<BV5DTOBoard> findAllBoards(){return bv5Mapper.findAllBoards();}
    public List<BV5DTOPost> findAllPosts(){return bv5Mapper.findAllPosts();}
    public List<BV5DTOComment> findAllComments(){return bv5Mapper.findAllComments();}
    public List<BV5DTOPost> findPostsByBoardId(int boardId) {
        List<BV5DTOPost> result = new ArrayList<>();
        for (BV5DTOPost post : findAllPosts()) {
            if (post.getBoardId() == boardId) {
                result.add(post);
            }
        }
        return result;
    }
    public List<BV5DTOComment> findCommentsByPostId(int postId) {
        List<BV5DTOComment> result = new ArrayList<>();
        for (BV5DTOComment comment : findAllComments()) {
            if (comment.getPostId() == postId) {
                result.add(comment);
            }
        }
        return result;
    }

    public BV5DTOBoard findoneBoard(int boardId) {
        return bv5Mapper.findOneBoard(boardId);
    }

    public BV5DTOPost findonePost(int postId) {
        return bv5Mapper.findOnePost(postId);
    }
    public BV5DTOComment findoneComment(int commentId){
        return bv5Mapper.findOneComment(commentId);
    }
    @Transactional
    public void addNewPost(BV5DTOPost bv5DTOPost){
        bv5DTOPost.setCreatedAt(java.time.LocalDateTime.now());
        bv5DTOPost.setUpdatedAt(java.time.LocalDateTime.now());
        bv5DTOPost.setViewCount(0);
        bv5Mapper.addNewPost(bv5DTOPost);
    }
    @Transactional
    public void updatePost(BV5DTOPost bv5DTOPost) {
        bv5DTOPost.setUpdatedAt(java.time.LocalDateTime.now());
        bv5Mapper.updatePost(bv5DTOPost);
    }
    @Transactional
    public void deletePost(BV5DTOPost bv5DTOPost) {
        bv5Mapper.deletePost(bv5DTOPost);
    }
    @Transactional
    public void addNewComment(BV5DTOComment bv5DTOComment){
        bv5DTOComment.setCreatedAt(java.time.LocalDateTime.now());
        bv5DTOComment.setUpdatedAt(java.time.LocalDateTime.now());

        bv5Mapper.addComment(bv5DTOComment);
    }
    @Transactional
    public void updateComment(BV5DTOComment bv5DTOComment) {
        bv5DTOComment.setUpdatedAt(java.time.LocalDateTime.now());
        bv5Mapper.updateComment(bv5DTOComment);
    }
    @Transactional
    public void deleteComment(BV5DTOComment bv5DTOComment) {
        bv5Mapper.deleteComment(bv5DTOComment);
    }
}

