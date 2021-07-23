package org.petersix.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.petersix.tools.GenKey;
import org.petersix.tools.TransCoder;

public class TranscodeController {
    public JFXTextArea txtClair;
    public JFXTextArea txtEncode;
    public JFXButton genBtn;
    public TextField keyField;
    public JFXToggleButton keyLock;
    private TransCoder transCoder;
    private GenKey key;


    @FXML
    public void initialize(){
        txtClair.textProperty().addListener(evt -> encodeTxt());

        txtEncode.textProperty().addListener(evt-> decodeTxt());

        keyField.textProperty().addListener(evt ->createTranscoder());
    }

    public void encodeTxt() {
        if(txtClair.isFocused()){
        System.out.println("encode");
        if(keyField.getText().isEmpty()) genKey();
        StringBuilder msg = new StringBuilder();
        for (String line : txtClair.getText().split("\n")) msg.append(transCoder.encode(line)).append("\n");
        txtEncode.setText(msg.toString());}
    }

    public void decodeTxt() {
        if(txtEncode.isFocused()){
            System.out.println("decode");
            if(keyField.getText().isEmpty()) genKey();
            StringBuilder msg = new StringBuilder();
            for (String line : txtEncode.getText().split("\n")) msg.append(transCoder.decode(line)).append("\n");
            txtClair.setText(msg.toString());}

    }

    public void userGenKey(ActionEvent event){
        txtEncode.clear();
        txtClair.clear();
        genKey();
    }

    public void genKey() {
        key = new GenKey("");
        keyField.setText(key.getGeneratedCryptedKey());
    }

    public void createTranscoder() {
        key = new GenKey("",keyField.getText());
        transCoder = new TransCoder(key);
    }

    public void unlock(ActionEvent event) {
        genBtn.setVisible(!keyLock.isSelected());
        keyField.setDisable(keyLock.isSelected());
    }
}
