package Exceptions;

import java.util.Scanner;

public class ExcecaoPersonalizada {
    public static void main(String[] args) {
        logar();
    }

    private static void logar(){
        Scanner sc = new Scanner(System.in);
        String usuario = "leandro";
        String senha = "1234";
        System.out.print("Usuario: ");
        String usuarioDigitado = sc.nextLine();
        System.out.print("Senha: ");
        String senhaDigitado = sc.nextLine();
        if(!usuario.equals(usuarioDigitado) || !senha.equals(senhaDigitado)){
            throw new LoginInvalidoException("Usuário inválido");
        }
        System.out.println("Login realizado com sucesso");
    }
}
