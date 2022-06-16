package game_project;

public class QuizExercise{
    public static void start(){
        System.out.println("QUIZ EXERCISE");

        Quiz tim = new Quiz("u1234");
        tim.takeTest();
        Quiz.completedQuiz.add(tim);
        System.out.println(tim);

        double average = Quiz.calculateAverage();
        System.out.format("Current average: %f\n\n", average);

        
        Quiz bacon = new Quiz("asfsafdf");
        bacon.takeTest();
        Quiz.completedQuiz.add(bacon);
        System.out.println(bacon);

        average = Quiz.calculateAverage();
        System.out.format("Current average: %f\n", average);

    }
}
