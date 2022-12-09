package classes;

public class Cartas {

    private String simbolo;
    private String naipe;
    private int valor;

    public Cartas() {
    }

    public Cartas(String simbolo, String naipe, int valor) {
        this.simbolo = simbolo;
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }



    public String imagePath() {

        if(naipe.equals("paus")){
            return  "imagens/" + simbolo+"paus.png";
        }else if(naipe.equals("ouros")){
            return "imagens/" +simbolo+"ouro.png";
        } else if(naipe.equals("espadas")){
            return "imagens/" +simbolo+"espada.png";
        } else {
            return "imagens/" +simbolo+"copas.png";
        }
    }

}
