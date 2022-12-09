package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Humano extends Jogador {
    private Scanner scanner = new Scanner(System.in);
    private Cartas c;


    @Override
    public int valorJogador() {
        return super.valorJogador();
    }

    public Humano(int jogador) {
        super(jogador);
    }


}
