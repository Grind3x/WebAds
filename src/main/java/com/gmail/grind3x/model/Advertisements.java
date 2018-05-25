package com.gmail.grind3x.model;

import java.util.ArrayList;
import java.util.List;

public class Advertisements {
    private static Advertisements advertisements = new Advertisements();
    private List<Advertisement> advList = new ArrayList<>();

    private Advertisements() {
    }

    public static Advertisements getInstance() {
        return advertisements;
    }

    public void add(Advertisement advertisement) {
        if (advertisement == null) {
            throw new IllegalArgumentException();
        }
        advList.add(advertisement);
    }

    public List<Advertisement> getAdvList() {
        return advList;
    }

    public void setAdvList(List<Advertisement> advList) {
        this.advList = advList;
    }

    @Override
    public String toString() {
        return "Advertisements{" +
                "advList=" + advList +
                '}';
    }
}
