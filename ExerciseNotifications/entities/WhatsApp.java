package ExerciseNotifications.entities;

import ExerciseNotifications.interfaces.Notificacao;

public class WhatsApp implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
        log(mensagem);
    }

    
    

}
