package com.ohgiraffers.com.board;

public class BoardDTO {
    private Integer boardId;
    private String name;
    private String description;
    public BoardDTO(){}

    public BoardDTO(Integer boardId, String name, String description) {
        this.boardId = boardId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boardId=" + boardId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
