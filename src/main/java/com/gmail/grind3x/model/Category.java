package com.gmail.grind3x.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {
    @Id
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    public Category() {
    }

    public Category(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(image, category.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, image);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
