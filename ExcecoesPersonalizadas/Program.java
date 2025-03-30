package ExcecoesPersonalizadas;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        Integer numeroQuarto = sc.nextInt();
        System.out.print("Check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: Chek-Out deve ser depois do Check-In");
        }else {
            Reservas reserva = new Reservas(numeroQuarto, checkIn,checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite as datas para atualizar a reserva: ");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String erro = reserva.atualizarDatas(checkIn, checkOut);
            if(erro != null){
                System.out.println("Erro na reserva: " + erro);
            }else {
                System.out.println("Reserva: " + reserva);
            }

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);



        }



        
        sc.close();
    }
}
