package org.example.cases;

import org.example.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningCase {
    private List<Screening> screeningsList = new ArrayList<>();

    private MovieCase movieCase;

    public ScreeningCase(MovieCase movieCase) {
        this.movieCase = movieCase;
        initData();
    }

    public Screening getScreening(int index) {
        return screeningsList.get(index);
    }

    public List<Screening> getScreeningList() {
        return screeningsList;
    }

    private void screeningsList() {

    }

    private void initData() {


        Hall hall1 = new Hall(1, 120);
        Hall hall2 = new Hall(2, 250);
        Hall hall3 = new Hall(3, 250);

        Screening screening1 = new Screening(movieCase.getMovie(0),
                LocalDateTime.of(
                        2024, 2, 26, 13, 20, 0, 0),
                hall1,
                119,
                5.99
        );
        Screening screening2 = new Screening(movieCase.getMovie(1),
                LocalDateTime.of(
                        2024, 2, 26, 16, 45, 0, 0),
                hall2,
                112,
                7.39
        );
        Screening screening3 = new Screening(movieCase.getMovie(2),
                LocalDateTime.of(
                        2024, 2, 26, 14, 00, 0, 0),
                hall3,
                56,
                7.39
        );
        Screening screening4 = new Screening(movieCase.getMovie(1),
                LocalDateTime.of(
                        2024, 2, 27, 11, 00, 0, 0),
                hall1,
                26,
                5.99
        );
        Screening screening5 = new Screening(movieCase.getMovie(0),
                LocalDateTime.of(
                        2024, 2, 27, 16, 20, 0, 0),
                hall3,
                96,
                7.39
        );
        Screening screening6 = new Screening(movieCase.getMovie(0),
                LocalDateTime.of(
                        2024, 2, 27, 14, 00, 0, 0),
                hall2,
                249,
                5.99
        );
        Screening screening7 = new Screening(movieCase.getMovie(1),
                LocalDateTime.of(
                        2024, 2, 28, 11, 00, 0, 0),
                hall1,
                100,
                5.99
        );
        Screening screening8 = new Screening(movieCase.getMovie(2),
                LocalDateTime.of(
                        2024, 2, 28, 18, 20, 0, 0),
                hall2,
                63,
                7.39
        );

        screeningsList.add(screening1);
        screeningsList.add(screening2);
        screeningsList.add(screening3);
        screeningsList.add(screening4);
        screeningsList.add(screening5);
        screeningsList.add(screening6);
        screeningsList.add(screening7);
        screeningsList.add(screening8);
    }
}
