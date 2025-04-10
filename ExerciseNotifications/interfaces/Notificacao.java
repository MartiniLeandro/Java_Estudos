package ExerciseNotifications.interfaces;

public interface Notificacao {
    
    void enviar(String mensagem);

    default void log(String mensagem) {
        System.out.println("[LOG - " + getClass().getSimpleName() + "] Mensagem enviada: " + mensagem);
    }
    
}
