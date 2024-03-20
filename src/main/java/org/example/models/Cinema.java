package org.example.models;

import org.example.Annotations.CinemaAnnotation;

import java.util.List;

@CinemaAnnotation(franchise = "MyMovieINC", owner = "Edgar")
public class Cinema {
    public String name;
    public List<Screening> screeningList;
    public String address;

    public Cinema(String name, List<Screening> screeningList, String address) {
        this.name = name;
        this.screeningList = screeningList;
        this.address = address;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screening> screeningList() {
        return screeningList;
    }

    public void setScreeningList(List<Screening> screeningList) {
        this.screeningList = screeningList;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
