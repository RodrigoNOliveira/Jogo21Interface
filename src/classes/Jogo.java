package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private Scanner scanner;
    private Baralho baralho;
    private Humano humano;
    private Cartas c;
    boolean valida = true;
    boolean valida1 = true;

    public Cartas getC() {
        return c;
    }

    public void setC(Cartas c) {
        this.c = c;
    }

    private Cartas c1;
    private int jogada = 0;
    private ArrayList<Jogador> listaJogador = new ArrayList<>();

    public Jogo() {
        baralho = new Baralho();
        //scanner = new Scanner(System.in);
    }


    public void cadastroMultiplayer() {
        for (int i = 0; i < 2; i++) {
            humano = new Humano(i + 1);
            this.listaJogador.add(humano);
        }
    }


    public ArrayList<Jogador> getListaJogador() {
        return listaJogador;
    }

    public void setListaJogador(ArrayList<Jogador> listaJogador) {
        this.listaJogador = listaJogador;
    }
}
