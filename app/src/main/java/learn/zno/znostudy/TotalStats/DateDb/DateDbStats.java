package learn.zno.znostudy.TotalStats.DateDb;

public class DateDbStats {

    int id;
    String question;
    String yourAnswer;
    String RightAnswer;

    public DateDbStats() {

    }

    public DateDbStats(int id, String question, String yourAnswer, String RightAnswer) {
        this.id = id;
        this.question = question;
        this.yourAnswer = yourAnswer;
        this.RightAnswer = RightAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getYourAnswer() {
        return yourAnswer;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setYourAnswer(String answer1) {
        this.yourAnswer = yourAnswer;
    }

    public void setRightAnswer(String answer2) {
        this.RightAnswer = RightAnswer;
    }
}
