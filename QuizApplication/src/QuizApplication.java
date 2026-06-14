import java.util.Scanner;

public class QuizApplication{
    public static void main(String[] args){

        Question[] questions = createQuestions();
        int score = startQuiz(questions);
        showResult(score, questions.length);
        new QuizGUI();
    }


    //this method is for making creating questions

    public static Question[] createQuestions() {

        Question[] questions = new Question[3];

        questions[0] = new Question(
                "Which company created Java?",
                "Microsoft",
                "Apple",
                "Sun Microsystems",
                "Google",
                'C'
        );

        questions[1] = new Question(
                "Which keyword is used to create an object?",
                "class",
                "new",
                "void",
                "static",
                'B'
        );

        questions[2] = new Question(
                "Which method is the entry point of a Java program?",
                "start()",
                "run()",
                "main()",
                "execute()",
                'C'
        );

        return questions;
    }


    //this method is to check the answer choose by the user is correct or not
    static int startQuiz(Question[] questions){
        Scanner sc = new Scanner(System.in);
        int score =0;
        for(int i=0;i < questions.length;i++){
            questions[i].displayQuestion();
            System.out.println("Enter your answer: ");
            int res = sc.next().toUpperCase().charAt(0);
            if (res==questions[i].getCorrectAnswer()){
                System.out.println("Correct!!");
                score++;
            }
            else {
                System.out.println("Wrong! the Correct answer is: " + questions[i].getCorrectAnswer());
            }

        }
        return score;
    }


    //this method to show result of the quiz
    static void showResult(int score, int totalQuestions){
        double percentage = (score*100.0)/totalQuestions;

        System.out.println("\n===== RESULT =====");
        System.out.println("Score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage>=80){
            System.out.println("Excellent!");
        }
        else if (percentage >= 60) {

            System.out.println("Good Job!");

        } else {

            System.out.println("Keep Practicing!");
        }
    }


}







