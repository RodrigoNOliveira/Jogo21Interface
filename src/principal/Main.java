package principal;

import javafx.application.Application;
import javafx.event.EventDispatchChain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    private  static  Scene tela;

    public static void main(String[] args) throws Exception {
        launch();
    }




    @Override
    public void start(Stage palco) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "../TelaInicial.fxml"));
        Parent raiz = fxmlLoader.load();
        tela = new Scene(raiz);
        palco.setTitle("JOGO 21");
        palco.setScene(tela);
        palco.show();

    }
    public static void setRaiz(String fxml, double altura, double largura) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        tela.getWindow().setHeight(altura);
        tela.getWindow().setWidth(largura);
        tela.setRoot(fxmlLoader.load());
    }

    public  static  Scene getTela(){
        return  tela;
    }

}
