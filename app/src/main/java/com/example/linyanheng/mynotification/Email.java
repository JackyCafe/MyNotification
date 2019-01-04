package com.example.linyanheng.mynotification;

import java.io.Serializable;

public class Email implements Serializable {
    private String title;
    private String content;

    public Email(String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "Email{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
