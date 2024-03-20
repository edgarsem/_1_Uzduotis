package org.example.cases;

import org.example.Exceptions.MovieNotFoundException;
import org.example.models.Cinema;
import org.example.models.Screening;

import java.util.ArrayList;
import java.util.List;

public class CinemaCase {
    private List<Cinema> cinemaList = new ArrayList<>();
    private Cinema currentCinema;
    private ScreeningCase screeningCase;
    public CinemaCase(ScreeningCase screeningCase) {
        this.screeningCase = screeningCase;
        initData();
    }

    public void addCinema(Cinema cinema) {
        cinemaList.add(cinema);
    }

    public Cinema getCinema(int index) {
        return cinemaList.get(index);
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCurrentCinema(Cinema cinema) {
        this.currentCinema = cinema;
    }

    public Cinema getCurrentCinema() {
        return currentCinema;
    }

    public List<String> findScreenings(String movieTitle) {
        List<String> foundScreeningsList = new ArrayList<>();
        for (Cinema cinema : cinemaList)
        {
            for(Screening screening : cinema.screeningList())
            {
                if(screening.movie().getTitle().equals(movieTitle))
                {
                    foundScreeningsList.add(
                            cinema.name + ", " + cinema.address
                            + " | " + screening.screeningTime()
                                    + " | " + screening.hall().hallNumber()
                                    + " | " + screening.getBooked()
                                    + "/" + screening.hall().seatNumber()
                                    + " | " + screening.getCost()
                    );
                }
            }
        }
        if (foundScreeningsList.size() == 0)
        {
            throw new MovieNotFoundException("Movie not found");
        } else {
            return foundScreeningsList;
        }
    }

    private void initData() {
        Cinema cinema1 = new Cinema(
                "MyMovie Ozas",
                List.of(
                        screeningCase.getScreening(0),
                        screeningCase.getScreening(2),
                        screeningCase.getScreening(4),
                        screeningCase.getScreening(6)
                ),
                "Ozo g. 18, 08243 Vilnius"
        );
        Cinema cinema2 = new Cinema(
                "MyMovie Outlet",
                List.of(
                        screeningCase.getScreening(1),
                        screeningCase.getScreening(3),
                        screeningCase.getScreening(5),
                        screeningCase.getScreening(7)
                        ),
                "Vytauto Pociūno g. 8, 06264 Vilnius"
        );
        cinemaList.add(cinema1);
        cinemaList.add(cinema2);
    }
}
