package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DesignController {
	@FXML
	private TextField txf ;
	private float a,b; private String op;
	@FXML
	private void num(ActionEvent event) {
		Object obj = event.getSource();
		Button btn = (Button) obj;
		String s = txf.getText();
		if (s.equals("0") && btn.getText()!="0")
			txf.setText(btn.getText());
		else {
			s+=btn.getText();
			txf.setText(s);
		}
	}
	
	@FXML
	private void oper(ActionEvent event) {
		a=Float.parseFloat(txf.getText());
		Object obj = event.getSource();
		Button btn = (Button) obj;
		op=btn.getText();
		txf.setText("0");
	}
	@FXML
	private void result() {
		b=Float.parseFloat(txf.getText());
		if (op.equals("+"))
			txf.setText(Float.toString(a+b));
		else if (op.equals("-"))
			txf.setText(Float.toString(a-b));
		else if (op.equals("*"))
			txf.setText(Float.toString(a*b));
		else if(op.equals("/")) {
			if (b==0)
				txf.setText("Can not devide by 0!");
			
			else {
				float result = a/b;
				txf.setText(Float.toString(result));
			}
		}
	}
	
	@FXML
	void clearAll() {
		txf.setText("0");
	}
	@FXML
	void clear() {
		String s=txf.getText();
		s=s.substring(0, s.length()-1);
		if (s.isEmpty())
			txf.setText("0");
		else
			txf.setText(s);
	}
	@FXML
	void negt() {
		String s=txf.getText();
		float x = Float.parseFloat(s);
		if (x>0)
		    s="-"+s;
		else 
			s=s.substring(1);
		txf.setText(s);
	}
	@FXML
	void flt() {
		String s = txf.getText();
		if (!s.contains("."))
			s+=".";
			txf.setText(s);
	}
}