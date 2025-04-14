package ExerciseSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<User> users = new HashSet<>();

        System.out.print("Caminho completo do arquivo: ");
        String path = sc.next();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while(line != null){
                String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));

                users.add(new User(username, moment));
                line = bf.readLine();
            }
            System.out.println("Total users: " + users.size());
        }catch(IOException e ){
            System.out.println("Error: " + e.getMessage());
        }




        sc.close();
    }
}
