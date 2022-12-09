package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import principal.Main;

import java.io.IOException;

public class Notificacao{

    public static void mostraNotificacao(String titulo, String cabecalho,
        String mensagem, AlertType tipo) throws IOException {

            //objeto que representa a janela de notificacao
            Alert popupNotificacao = new Alert(tipo);
            //adiciona o titulo na janela
            popupNotificacao.setTitle(titulo);
            //adiciona o cabecalho da janela
            popupNotificacao.setHeaderText(cabecalho);
            //adiciona a mensagem que será mostrada na janela
            popupNotificacao.setContentText(mensagem);
            //abre a janela de notificacao
            popupNotificacao.show();


    }

}