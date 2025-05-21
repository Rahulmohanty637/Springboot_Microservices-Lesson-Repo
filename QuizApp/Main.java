package QuizApp;

public class Main {
    public static void main(String[] args) {
        QuestionService obj = new QuestionService();
        obj.playQuiz();
        obj.printScore();
    }
}
