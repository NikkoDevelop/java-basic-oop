package classes;

import java.io.Serializable;
public class Test extends Letter implements Serializable {

    private static final long serialVersionUID = 2L;


    private String testForm;
    private String testDate;
    private int totalScoreForAutomaticAssessment;

    public Test(
            String title,
            String professorName,
            int lectureHours,
            int practiceHours,
            String testForm,
            String testDate,
            int totalScoreForAutomaticAssessment
    ) {
        super(title, professorName, lectureHours, practiceHours);

        this.testForm = testForm;
        this.testDate = testDate;
        this.totalScoreForAutomaticAssessment = totalScoreForAutomaticAssessment;
    }

    public String writeData() {
        return "Зачет" + "\n" +
                "Название предмета: " + get_title() + "\n" +
                "Преподаватель: " + get_professorName() + "\n" +
                "Лекционные часы: " + get_lectureHours() + "\n" +
                "Практиические часы: " + get_practiceHours() + "\n" +
                "Форма зачета: " + this.testForm + "\n" +
                "Дата зачета: " + this.testDate + "\n" +
                "Балл для получения оценки автоматом: " + this.totalScoreForAutomaticAssessment;
    }

}
