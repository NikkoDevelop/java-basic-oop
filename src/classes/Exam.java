package classes;

import java.io.Serializable;

public class Exam extends Letter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String examForm;
    private String examDate;
    int totalScoreForAutomaticAssessment;

    public Exam(
            String title,
            String professorName,
            int lectureHours,
            int practiceHours,
            String examForm,
            String examDate,
            int totalScoreForAutomaticAssessment
    ) {
        super(title, professorName, lectureHours, practiceHours);

        this.examForm = examForm;
        this.examDate = examDate;
        this.totalScoreForAutomaticAssessment = totalScoreForAutomaticAssessment;
    }

    public String writeData() {
        return "Экзамен" + "\n" +
                "Название предмета: " + get_title() + "\n" +
                "Преподаватель: " + get_professorName() + "\n" +
                "Лекционные часы: " + get_lectureHours() + "\n" +
                "Практиические часы: " + get_practiceHours() + "\n" +
                "Форма экзамена: " + this.examForm + "\n" +
                "Дата экзамена: " + this.examDate + "\n" +
                "Балл для получения оценки автоматом: " + this.totalScoreForAutomaticAssessment;
    }

}