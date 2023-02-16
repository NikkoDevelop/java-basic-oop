package classes;

import java.io.Serializable;

abstract public class Letter implements Serializable {

    private String title;
    private String professorName;
    private int lectureHours;
    private int practiceHours;

    protected Letter(String title, String professorName, int lectureHours, int practiceHours) {
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
