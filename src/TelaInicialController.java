import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import principal.Main;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class TelaInicialController {

        @FXML
        private Button botaoIniciar;


        @FXML
        private ImageView imgFundo;


        @FXML
        void iniciarJogo(ActionEvent event) throws IOException {
                Main.setRaiz("../TelaJogo.fxml",680.0, 995.0);       }

}


