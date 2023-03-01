package uz.gita.testapp.model;

public class Answer {
    private int answer;
    private int answerByPosition;

    public Answer(int answer, int answerByPosition) {
        this.answer = answer;
        this.answerByPosition = answerByPosition;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getAnswerByPosition() {
        return answerByPosition;
    }

    public void setAnswerByPosition(int answerByPosition) {
        this.answerByPosition = answerByPosition;
    }

    /* private static Answer instance;

    public static Answer getInstance() {
        if (instance == null) {
            instance = new Answer();
        }
        return instance;
    }*/
}
