package ExercisePost;

import java.time.LocalDateTime;

public class ProgramCourse {
    public static void main(String[] args) {
        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        Post post1 = new Post(LocalDateTime.now(), "Traveling to New Zealand", "I'm going to visit this wonderful country", 12);
        post1.addComent(c1);
        post1.addComent(c2);
        
        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the force be with you");
        Post post2 = new Post(LocalDateTime.now(), "Good night guys", "See you tomorrow",5);
        post2.addComent(c3);
        post2.addComent(c4);

        System.out.println(post1);
        System.out.println("----------------------");
        System.out.println(post2);
    }
}
