package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    double num1;
    double num2;
    int temp = 0;
    boolean ck;

    @FXML
    private TextField disply;
    @FXML
    private Button buttonzero;
    @FXML
    private Button buttondot;
    @FXML
    private Button buttonequal;
    @FXML
    private Button buttonplus;
    @FXML
    private Button buttonone;
    @FXML
    private Button buttontwo;
    @FXML
    private Button buttonthree;
    @FXML
    private Button buttonminus;
    @FXML
    private Button buttonfor;
    @FXML
    private Button buttonfive;
    @FXML
    private Button buttonsix;
    @FXML
    private Button buttonmulti;
    @FXML
    private Button buttonseven;
    @FXML
    private Button buttoneight;
    @FXML
    private Button buttonnine;
    @FXML
    private Button buttond;
    @FXML
    private Button ButtonClear;
    @FXML
    private Button ButtonAllClear;
    @FXML
    private Button ButtonSQRT;
    @FXML
    private Button ButtonSQR;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disply.requestFocus();
    }

    @FXML
    private void handleDigitDotAction(ActionEvent event) {
        String otext = disply.getText();
        if (!otext.contains(".")) {
            String text = otext + ".";
            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }
    }

    @FXML
    private void handleDigitZeroAction(ActionEvent event) {
        
        if (ck == true) {
            disply.clear();
            disply.setText("0");
            ck = false;

        } else {
            String otext = disply.getText();
            String text = otext + "0";

            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }

    }

    @FXML
    private void handleDigitOneAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("1");
            ck = false;

        } else {
            String otext = disply.getText();
            String text = otext + "1";

            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }
    }

    @FXML
    private void handleDigitTwoAction(ActionEvent event) {

        if (ck == true) {
            disply.clear();
            disply.setText("2");
            ck = false;

        } else {
            String otext = disply.getText();
            String text = otext + "2";

            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }
    }

    @FXML
    private void handleDigitThreeAction(ActionEvent event) {

        if (ck == true) {
            disply.clear();
            disply.setText("3");
            ck = false;

        } else {
            
            String otext = disply.getText();
            String text = otext + "3";

            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }
    }

    @FXML
    private void handleDigitForeAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("4");
            ck = false;

        } else {
            String otext = disply.getText();
            String text = otext + "4";

            disply.setText(text);

            disply.requestFocus();
            disply.positionCaret(text.length());
        }
    }

    @FXML
    private void handleDigitFIveAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("5");
            ck = false;

        }else {String otext = disply.getText();
        String text = otext + "5";

        disply.setText(text);

        disply.requestFocus();
        disply.positionCaret(text.length());
                }
    }

    @FXML
    private void handleDigitSixAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("6");
            ck = false;

        }else{String otext = disply.getText();
        String text = otext + "6";

        disply.setText(text);

        disply.requestFocus();
        disply.positionCaret(text.length());
                }
    }

    @FXML
    private void handleDigitSevenAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("7");
            ck = false;

        }else{String otext = disply.getText();
        String text = otext + "7";

        disply.setText(text);

        disply.requestFocus();
        disply.positionCaret(text.length());
                }
    }

    @FXML
    private void handleDigitEightAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("8");
            ck = false;

        }else{String otext = disply.getText();
        String text = otext + "8";

        disply.setText(text);

        disply.requestFocus();
        disply.positionCaret(text.length());}
    }

    @FXML
    private void handleDigitNineAction(ActionEvent event) {
        if (ck == true) {
            disply.clear();
            disply.setText("9");
            ck = false;

        }else{String otext = disply.getText();
        String text = otext + "9";

        disply.setText(text);

        disply.requestFocus();
        disply.positionCaret(text.length());
                }
    }

    @FXML
    private void handleDigitPlusAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        temp = 1;
        disply.clear();
    }

    @FXML
    private void handleDigitMinusAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        temp = 2;
        disply.clear();
    }

    @FXML
    private void handleDigitMultiAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        temp = 3;
        disply.clear();
    }

    @FXML
    private void handleDigitDAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        temp = 4;
        disply.clear();
    }

    @FXML
    private void handleDigitEqualAction(ActionEvent event) {
        if (temp == 0) {
            return;
        }
        num2 = Double.parseDouble(disply.getText());
        double result = 0;
        switch (temp) {
            case 1:
                result = num1 + num2;
                disply.setText("" + result);
                break;

            case 2:
                result = num1 - num2;
                disply.setText("" + result);
                break;

            case 3:
                result = num1 * num2;
                disply.setText("" + result);
                break;

            case 4:
                result = num1 / num2;
                disply.setText("" + result);
                break;

            default:
                disply.setText("" + num1);
                break;

        }
        ck = true;

    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        String oldText = disply.getText();
        if (oldText.length() > 0) {
            String newText = oldText.substring(0, oldText.length() - 1);
            disply.setText(newText);
        }

    }

    @FXML
    private void handleAllClearAction(ActionEvent event) {
        disply.clear();
    }

    @FXML
    private void handleSQRTAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        double rot = Math.sqrt(num1);
        disply.setText(""+rot);
    }

    @FXML
    private void handleSQRAction(ActionEvent event) {
        num1 = Double.parseDouble(disply.getText());
        disply.setText(""+num1*num1);
    }

}
