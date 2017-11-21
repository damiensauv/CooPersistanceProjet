import javax.swing.*;

import Frames.MaFrameConnexion;

import java.awt.*;

public class Main {

	public static void main(String[] args) {



	}
	
	public void launchUi(){

		MaFrameConnexion laframe = new MaFrameConnexion();

		laframe.setLocationRelativeTo(null);
		laframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laframe.setVisible(true);
		laframe.setSize(1000, 300);
		
	}
	
	
}