package classes;

import java.io.Serializable;

public class Letter implements Serializable {

    String title;
    String professorName;
    int lectureHours;
    int practiceHours;

    public Letter(String title, String professorName, int lectureHours, int practiceHours) {
        this.title = title;
        this.professorName = professorName;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
    }

    String get_title() {
        return this.title;
    }

    String get_professorName() {
        return this.professorName;
    }

    int get_lectureHours() {
        return this.lectureHours;
    }

    int get_practiceHours() {
        return this.practiceHours;
    }

}
