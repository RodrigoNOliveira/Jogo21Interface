import classes.Baralho;
import classes.Cartas;
import classes.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import principal.Main;
import util.Notificacao;
import java.io.IOException;
import java.util.ArrayList;

public class TelaJogoController {
    private Baralho b1 = new Baralho();
    private Jogo jogo = new Jogo();

    private String texto;
    private int rodada=0;


    int clique=3;
    int cont;
    private ArrayList<ImageView> listCartas = new ArrayList<>();
    private ArrayList<ImageView> listCartasOpon = new ArrayList<>();


    private void cartas(){
        listCartas.add(carta1);
        listCartas.add(carta2);
        listCartas.add(carta3);
        listCartas.add(carta4);
        listCartas.add(carta5);

    }

    private void cartasOpon(){
        listCartasOpon.add(cartaOponente1);
        listCartasOpon.add(cartaOponente2);
        listCartasOpon.add(cartaOponente3);
        listCartasOpon.add(cartaOponente4);
        listCartasOpon.add(cartaOponente5);
    }





    public ArrayList<ImageView> getListCartas() {
        return listCartas;
    }

    public void setListCartas(ArrayList<ImageView> listCartas) {
        this.listCartas = listCartas;
    }

    public void visibilidade(){
        botaoMultiplayer.setVisible(false);
        botaoMultiplayer.setDisable(true);
        botaoComecar.setVisible(false);
        botaoComecar.setDisable(true);
        msgSelecModo.setVisible(false);
        msgSelecModo.setDisable(true);
        botaoComprar.setDisable(false);
        botaoComprar.setVisible(true);
        botaoNaoComprar.setVisible(true);
        botaoNaoComprar.setDisable(false);
        carta1.setVisible(true);
        carta1.setDisable(false);
        carta2.setVisible(true);
        carta2.setDisable(false);
        cartaOponente1.setVisible(true);
        cartaOponente1.setDisable(false);
        cartaOponente2.setVisible(true);
        cartaOponente2.setDisable(false);
        labelJogador.setVisible(true);
        labelRodada.setVisible(true);
        labelNmrJgdr.setVisible(true);
        labelNmrRodada.setVisible(true);
        labelJogador1.setVisible(true);
        labelJogador2.setVisible(true);

    }

    public int jogadorVez() {
        if (rodada % 2 != 0) {
            return 1;
        } else
            return 2;
    }



    @FXML
    void iniciarTudo(ActionEvent event) throws IOException {
        rodada = 1;
        texto = "" +rodada;
        labelNmrRodada.setText(texto);
        texto = ""+jogadorVez();
        labelNmrJgdr.setText(texto);
        visibilidade();
        cartas();
        cartasOpon();
        Cartas c;
        b1.criaCartas();
        RadioButton radio = (RadioButton) opcoesModo.getSelectedToggle();
        jogo.cadastroMultiplayer();
        for (int i = 0; i < jogo.getListaJogador().size(); i++) {
            for (int e = 0; e < 2; e++) {
                c = b1.tiraCartas();
                jogo.getListaJogador().get(i).getListaCartas().add(c);
            }
        }

        for (int j = 0; j < 2; j++) {

            Cartas c0 = jogo.getListaJogador().get(0).getListaCartas().get(j);
            String value = c0.imagePath();
            Image img = new Image(getClass().getResource(
                    value).openStream());
            listCartas.get(j).setImage(img);
        }
        for (int j = 0; j < 2; j++) {
            Cartas c1 = jogo.getListaJogador().get(1).getListaCartas().get(j);
            String value = c1.imagePath();
            Image img = new Image(getClass().getResource(
                    value).openStream());
            listCartasOpon.get(j).setImage(img);
        }



    }




    @FXML
    void comprarCarta(ActionEvent event) throws IOException {

        int vez = jogadorVez();
        Cartas c = null;
         c = b1.tiraCartas();
        String value = c.imagePath();
        System.out.println(value);
        Image img = new Image(getClass().getResource(
                value).openStream());

        jogo.getListaJogador().get(vez-1).getListaCartas().add(c);

        if (vez==1)
        {
            jogo.getListaJogador().get(vez-1).setParou(false);
            String nome = "carta" + clique;
            for (int i = 0; i < listCartas.size(); i++) {
                System.out.println(listCartas.get(i).getId());
                if (listCartas.get(i).getId().equals(nome)) {
                    listCartas.get(i).setImage(img);
                    listCartas.get(i).setVisible(true);
                }
                }
            clique--;
            jogo.getListaJogador().get(vez-1).setParou(false);

        } else{
            String nome2 = "cartaOponente" + clique;
            for (int j = 0; j < listCartasOpon.size(); j++) {
                if(listCartasOpon.get(j).getId().equals(nome2)){
                    listCartasOpon.get(j).setImage(img);
                    listCartasOpon.get(j).setVisible(true);
                }
            }
            jogo.getListaJogador().get(vez-1).setParou(false);
        }


        if(jogo.getListaJogador().get(0).valorJogador() > 21){
            botaoComprar.setVisible(false);
            botaoNaoComprar.setVisible(false);
            Notificacao.mostraNotificacao("RESULTADO",
                    "Resultado da partida:",
                    "Jogador 1 estourou!!!\nJogador Vencedor: Jogador 2",
                    Alert.AlertType.INFORMATION);
            acabou();
        } else if (jogo.getListaJogador().get(1).valorJogador() > 21) {
            botaoComprar.setVisible(false);
            botaoNaoComprar.setVisible(false);
            Notificacao.mostraNotificacao("RESULTADO",
                    "Resultado da partida:",
                    "Jogador 2 estourou!!!\nJogador Vencedor: Jogador 1",
                    Alert.AlertType.INFORMATION);
            acabou();
        } else if (jogo.getListaJogador().get(vez-1).valorJogador() == 21) {
            botaoComprar.setVisible(false);
            botaoNaoComprar.setVisible(false);
            Notificacao.mostraNotificacao("RESULTADO",
                    "Resultado da partida:",
                    "Você completou 21\nJogador Vencedor: Jogador" + vez,
                    Alert.AlertType.INFORMATION);
            acabou();}
        rodada++;
        clique++;
        texto = "" +rodada;
        labelNmrRodada.setText(texto);
        vez = jogadorVez();
        texto = ""+vez;
        labelNmrJgdr.setText(texto);
    }


    public void acabou() throws IOException {

        jogarNovamente.setVisible(true);
        botaoSair.setVisible(true);

               }


    @FXML
    void naoComprar(ActionEvent event) throws IOException {
        int vez = jogadorVez();
        jogo.getListaJogador().get(jogadorVez()-1).parar();
        if(jogo.getListaJogador().get(0).getParou() && jogo.getListaJogador().get(1).getParou()){
            botaoComprar.setVisible(false);
            botaoNaoComprar.setVisible(false);
            if(jogo.getListaJogador().get(0).valorJogador()< jogo.getListaJogador().get(1).valorJogador()){
                Notificacao.mostraNotificacao("RESULTADO",
                        "Resultado da partida:",
                        "Ambos pararam ... calculando vencedor\nJogador ganhador: Jogador 2",
                        Alert.AlertType.INFORMATION);
                } else if (jogo.getListaJogador().get(0).valorJogador()> jogo.getListaJogador().get(1).valorJogador()) {
                Notificacao.mostraNotificacao("RESULTADO",
                        "Resultado da partida:",
                        "Ambos pararam ... calculando vencedor\nJogador ganhador: Jogador 1",
                        Alert.AlertType.INFORMATION);
                } else {
                Notificacao.mostraNotificacao("RESULTADO",
                        "Resultado da partida:",
                        "Ambos pararam ... calculando vencedor\nEMPATE",
                        Alert.AlertType.INFORMATION);
                }


            acabou();}
        if (jogadorVez()==2){
            clique++;
        }
        rodada++;
        texto = "" +rodada;
        labelNmrRodada.setText(texto);
        vez = jogadorVez();
        texto = ""+vez;
        labelNmrJgdr.setText(texto);

    }

    @FXML
    private Label labelJogador1;

    @FXML
    private Label labelJogador2;


    @FXML
    void botaoJogarNovamente(ActionEvent event) throws IOException {

        Main.setRaiz("../TelaJogo.fxml",680, 995);
    }

    @FXML
    void botaoSairJogo(ActionEvent event) throws Throwable {
        System.exit(0);
    }

    @FXML
    private Label msgSelecModo;

    @FXML
    private Button botaoComecar;

    @FXML
    private Button botaoComprar;

    @FXML
    private RadioButton botaoMultiplayer;

    @FXML
    private Button botaoSair;

    @FXML
    private Button jogarNovamente;


    @FXML
    private ToggleGroup opcoesModo;

    @FXML
    private Label labelJogador;

    @FXML
    private Label labelNmrJgdr;

    @FXML
    private Label labelNmrRodada;

    @FXML
    private Label labelRodada;
    @FXML
    private ImageView carta1;


    @FXML
    private ImageView carta2;

    @FXML
    private ImageView carta3;

    @FXML
    private ImageView carta4;

    @FXML
    private ImageView carta5;

    @FXML
    private ImageView cartaOponente1;

    @FXML
    private ImageView cartaOponente2;

    @FXML
    private ImageView cartaOponente3;

    @FXML
    private ImageView cartaOponente4;

    @FXML
    private ImageView cartaOponente5;

    @FXML
    private Button botaoNaoComprar;

}
