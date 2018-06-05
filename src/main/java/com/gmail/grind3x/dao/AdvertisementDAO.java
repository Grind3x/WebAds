package com.gmail.grind3x.dao;

import com.gmail.grind3x.model.Advertisement;
import com.gmail.grind3x.model.Category;

import java.util.List;

public interface AdvertisementDAO {
    List<Advertisement> getAll();

    void insert(Advertisement advertisement);

    void delete(Advertisement advertisement);

    List<Advertisement> findByAuthor(String name);

    Advertisement findById(Long id);

    void update(Advertisement advertisement);

    List<Advertisement> findByCategory(Category category);
}
