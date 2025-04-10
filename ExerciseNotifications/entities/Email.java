package ExerciseNotifications.entities;

import ExerciseNotifications.interfaces.Notificacao;

public class Email implements Notificacao {
    
    public void enviar(String mensagem){
        System.out.println("Enviando email: " + mensagem);
        log(mensagem);
    }
}
