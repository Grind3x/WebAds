package com.gmail.grind3x.model;

import java.util.Date;
import java.util.Objects;

public class Advertisement {
    private String author;
    private String title;
    private String text;
    private Date createDate;

    public Advertisement() {
    }

    public Advertisement(String author, String title, String text) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.createDate = new Date();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(title, that.title) &&
                Objects.equals(text, that.text) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, title, text, createDate);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
