package ExerciseNotifications;

import ExerciseNotifications.entities.Email;
import ExerciseNotifications.entities.SMS;
import ExerciseNotifications.entities.WhatsApp;
import ExerciseNotifications.interfaces.Notificacao;

public class Program {
    public static void main(String[] args) {
        Notificacao email = new Email();
        Notificacao SMS = new SMS();
        Notificacao WhatsApp = new WhatsApp();
    
        email.enviar("Seu boleto está disponível"); 
        SMS.enviar("Código de verificação: 123456");
        WhatsApp.enviar("Você recebeu uma mensagem");
    }
}
