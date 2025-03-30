package ExcecoesPersonalizadas;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reservas {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservas(){};

    public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut){
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto(){
        return this.numeroQuarto;
    }
    public Date getCheckIn(){
        return this.checkIn;
    }
    public Date getCheckOut(){
        return this.checkOut;
    }

    public void setNumeroQuarto(Integer numeroQuarto){
        this.numeroQuarto = numeroQuarto;
    }

    public long duracao(){
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
    public void atualizarDatas(Date checkIn, Date checkOut){
        Date agora = new Date();
        if(checkIn.before(agora) || checkOut.before(agora)){
            throw new IllegalArgumentException("Erro na reserva: atualização da data da reserva deve ser futuras ");
        }if(!checkOut.after(checkIn)){
            throw new IllegalArgumentException("Erro na reserva: Chek-Out deve ser depois do Check-In");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duracao() + " noites";
    }
}
