package com.example.vblogservice.entity.domian;

public class ArticleWithBLOBs extends Article {
    private String content;

    private byte[] cover;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}