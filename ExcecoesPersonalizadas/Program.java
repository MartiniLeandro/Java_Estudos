package ExcecoesPersonalizadas;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Numero do quarto: ");
            Integer numeroQuarto = scanner.nextInt();
            System.out.print("Check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.print("Check-Out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(scanner.next());


            Reservas reserva = new Reservas(numeroQuarto, checkIn,checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite as datas para atualizar a reserva: ");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-Out (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }catch(ParseException e){
            System.out.println("Formato de data inválida!!!");
        }catch(QuartoException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Erro inesperado");
        }
        
        scanner.close();
    }
}
