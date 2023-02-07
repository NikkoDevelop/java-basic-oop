package classes;

import java.io.Serializable;

public class Exam extends Letter implements Serializable {

    private static final long serialVersionUID = 1L;

    String examForm;
    String examDate;
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
                "Название предмета: " + this.title + "\n" +
                "Преподаватель: " + this.professorName + "\n" +
                "Лекционные часы: " + this.lectureHours + "\n" +
                "Практиические часы: " + this.practiceHours + "\n" +
                "Форма экзамена: " + this.examForm + "\n" +
                "Дата экзамена: " + this.examDate + "\n" +
                "Балл для получения оценки автоматом: " + this.totalScoreForAutomaticAssessment;
    }

}