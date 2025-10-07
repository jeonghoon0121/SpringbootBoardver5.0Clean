package com.ohgiraffers.com.post;

import java.time.LocalDateTime;

public class PostDTO {
    private Integer postId;
    private Integer boardId;
    private String authorId;
    private String password;
    private String title;
    private String content;
    private Integer viewCount;
    private String ipHash;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public PostDTO(){}

    public PostDTO(Integer postId, Integer boardId, String authorId, String password, String title, String content, Integer viewCount, String ipHash, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.boardId = boardId;
        this.authorId = authorId;
        this.password = password;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.ipHash = ipHash;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getIpHash() {
        return ipHash;
    }

    public void setIpHash(String ipHash) {
        this.ipHash = ipHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", boardId=" + boardId +
                ", authorId='" + authorId + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                ", ipHash='" + ipHash + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
