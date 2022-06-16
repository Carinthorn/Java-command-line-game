package game_project;

import java.util.ArrayList;

public class Quiz{

    //every quiz has a copy of this variable - it's own version of id
    public String id;

    //every quiz has a copy of this variable - it's own version of score
    public int score;

    public static ArrayList<Quiz> completedQuiz = new ArrayList<Quiz>();

    public Quiz(String student_id){
        id = student_id;
    }

    public String toString(){
        return String.format("StudentID: %s\nScore: %d", id, score);
    }

    public void takeTest(){
        score = 0;
        score = score + doQuestion1();
        score = score + doQuestion2();
    }

    public int doQuestion1(){
        String ans = Input.getString("Are you Tim?");
        if(ans.equalsIgnoreCase("yes")){
            return 10;
        }else{
            return 0;
        }
    }

    public int doQuestion2(){
        String ans = Input.getString("A or B comes first?");
        if(ans.equalsIgnoreCase("A")){
            return 10;
        }else{
            return 0;
        }
    }

    public static double calculateAverage() {
        int sum = 0;
        for (Quiz q: Quiz.completedQuiz) {
            sum = sum + q.score;
        }
        int numberOfQuiz = Quiz.completedQuiz.size();
        double average = sum/numberOfQuiz;
        return average;

    }
}



