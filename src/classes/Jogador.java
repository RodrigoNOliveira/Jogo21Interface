package classes;

import java.util.ArrayList;

public abstract class Jogador {

    private int jogador;
    private boolean parou = false;
    protected Jogo jogo;



    protected int valor;
    protected ArrayList<Cartas> listaCartas = new ArrayList<>();

    public Jogador(int jogador) {
        this.jogador = jogador;

    }

    public ArrayList<Cartas> getListaCartas() {
        return listaCartas;
    }


    public void setListaCartas(ArrayList<Cartas> listaCartas) {
        this.listaCartas = listaCartas;
    }

    public  void parar(){
        setParou(true);
    }

    public int valorJogador() {
        int total = 0;

        for (int j = 0; j < listaCartas.size(); j++) {
            total = total + listaCartas.get(j).getValor();
        }
        return total;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    public boolean getParou() {
        return parou;
    }

    public void setParou(boolean parou) {
        this.parou = parou;
    }

}
