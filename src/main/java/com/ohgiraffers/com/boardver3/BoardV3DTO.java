package com.ohgiraffers.com.boardver3;

public class BoardV3DTO {
    private Integer boardId;
    private String name;
    private String description;
    private Boolean isUserActive;
    private Boolean isAdminActive;
    public BoardV3DTO(){}

    public BoardV3DTO(Integer boardId, String name, String description, Boolean isUserActive, Boolean isAdminActive) {
        this.boardId = boardId;
        this.name = name;
        this.description = description;
        this.isUserActive = isUserActive;
        this.isAdminActive = isAdminActive;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUserActive() {
        return isUserActive;
    }

    public void setUserActive(Boolean userActive) {
        isUserActive = userActive;
    }

    public Boolean getAdminActive() {
        return isAdminActive;
    }

    public void setAdminActive(Boolean adminActive) {
        isAdminActive = adminActive;
    }

    @Override
    public String toString() {
        return "BoardV3DTO{" +
                "boardId=" + boardId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isUserActive=" + isUserActive +
                ", isAdminActive=" + isAdminActive +
                '}';
    }
}
