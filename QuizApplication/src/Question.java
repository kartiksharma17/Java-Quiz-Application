public class Question {
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private char correctAnswer;

    //getter method
    public char getCorrectAnswer() {
        return correctAnswer;
    }


    //constructor
    public Question(String questionText, String option1, String option2, String option3, String option4,char correctAnswer){
        this.questionText=questionText;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.correctAnswer=correctAnswer;
    }

    //methods for display questions
    void displayQuestion(){
        System.out.println(questionText);
        System.out.println("A. "+ option1 );
        System.out.println("B. "+ option2 );
        System.out.println("C. "+ option3 );
        System.out.println("D. "+ option4 );


    }


    //for frontend
    public String getQuestionText() {
        return questionText;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

}
