package com.ohgiraffers.com.boardver3;

import java.time.LocalDateTime;
import java.util.List;

public class PostV3DTO {
    private Integer postId;
    private Integer boardId;
    private String authorId;
    private String password;
    private String ipHash;
    private String attachmentUrl;
    private List<String> attachmentUrls;
    private String title;
    private String content;
    private String thumbnailUrl;

    private String accessLevel;
    private String status;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isNotice;
    private Boolean isSecret;

    public PostV3DTO(){}

    public PostV3DTO(Integer postId, Integer boardId, String authorId, String password, String ipHash, String attachmentUrl, List<String> attachmentUrls, String title, String content, String thumbnailUrl, String accessLevel, String status, Integer viewCount, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isNotice, Boolean isSecret) {
        this.postId = postId;
        this.boardId = boardId;
        this.authorId = authorId;
        this.password = password;
        this.ipHash = ipHash;
        this.attachmentUrl = attachmentUrl;
        this.attachmentUrls = attachmentUrls;
        this.title = title;
        this.content = content;
        this.thumbnailUrl = thumbnailUrl;
        this.accessLevel = accessLevel;
        this.status = status;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isNotice = isNotice;
        this.isSecret = isSecret;
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

    public String getIpHash() {
        return ipHash;
    }

    public void setIpHash(String ipHash) {
        this.ipHash = ipHash;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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

    public Boolean getNotice() {
        return isNotice;
    }

    public void setNotice(Boolean notice) {
        isNotice = notice;
    }

    public Boolean getSecret() {
        return isSecret;
    }

    public void setSecret(Boolean secret) {
        isSecret = secret;
    }

    @Override
    public String toString() {
        return "PostV3DTO{" +
                "postId=" + postId +
                ", boardId=" + boardId +
                ", authorId='" + authorId + '\'' +
                ", password='" + password + '\'' +
                ", ipHash='" + ipHash + '\'' +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", attachmentUrls=" + attachmentUrls +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", status='" + status + '\'' +
                ", viewCount=" + viewCount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isNotice=" + isNotice +
                ", isSecret=" + isSecret +
                '}';
    }
}
