package classes;

import java.io.Serializable;

abstract public class Letter implements Serializable {

    private String title;
    private String professorName;
    private int lectureHours;
    private int practiceHours;

    public Letter(String title, String professorName, int lectureHours, int practiceHours) {
        this.title = title;
        this.professorName = professorName;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
    }

    String get_title() {
        return this.title;
    }

    public String get_professorName() {
        return this.professorName;
    }

    public int get_lectureHours() {
        return this.lectureHours;
    }

    public int get_practiceHours() {
        return this.practiceHours;
    }

}
