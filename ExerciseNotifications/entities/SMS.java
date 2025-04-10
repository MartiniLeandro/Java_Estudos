package ExerciseNotifications.entities;

import ExerciseNotifications.interfaces.Notificacao;

public class SMS implements Notificacao {
    
    public void enviar(String mensagem){
        System.out.println("Enviando SMS: " + mensagem);
        log(mensagem);
    }
}
