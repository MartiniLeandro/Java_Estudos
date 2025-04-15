package ExerciseMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votes = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.next();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer count = Integer.parseInt(fields[1]);
                if(votes.containsKey(name)){
                    Integer votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                }else{
                    votes.put(name, count);
                }



                line = bf.readLine();
            }

        }catch(IOException e ){
            System.out.println("Error: " + e.getMessage());
        }

        for (String president : votes.keySet()) {
            System.out.println(president + ": " + votes.get(president));
        }



        sc.close();
    }
}
