package com.gmail.grind3x.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Advertisements")
public class Advertisement {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Advertisement() {
    }

    public Advertisement(String title, String text, Author author) {
        this.title = title;
        this.text = text;
        this.createDate = new Date();
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

    public Author getAuthor() {
        return author;
    }

    public Date getCreateDate() {
        return createDate;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(text, that.text) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, text, createDate, author);
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                ", author=" + author +
                '}';
    }
}
