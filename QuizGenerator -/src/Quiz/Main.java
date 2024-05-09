package Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Quiz {
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String name) {
        this.name = name;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the " + name + " Quiz!");
        System.out.println("Answer the following questions:");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i+1) + ": " + q.getQuestion());
            ArrayList<String> options = q.getOptions();
            Collections.shuffle(options);
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j+1) + ". " + options.get(j));
            }
            System.out.print("Your answer: ");
            int answerIndex = scanner.nextInt() - 1;
            String userAnswer = options.get(answerIndex);
            if (userAnswer.equals(q.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
                System.out.println("The correct answer is: " + q.getCorrectAnswer());
            }
        }

        System.out.println("\nQuiz completed!\nYour score: " + score + "/" + questions.size());
    }
}

class Question {
    private String question;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(String question, ArrayList<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Programming");
        quiz.addQuestion(new Question("What is the output of 2 + 2?", new ArrayList<>(List.of("3", "4", "5", "6")), "4"));
        quiz.addQuestion(new Question("What is the capital of France?", new ArrayList<>(List.of("London", "Paris", "Berlin", "Rome")), "Paris"));
        quiz.addQuestion(new Question("What is 5 * 5?", new ArrayList<>(List.of("20", "25", "30", "35")), "25"));

        quiz.takeQuiz();
    }
}
