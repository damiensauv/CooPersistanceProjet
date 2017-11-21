
import javax.swing.*;

import Frames.MaFrameConnexion;

import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Entity.Personne;
import Oracle.Oracle;
import Persistance.Mapper.PersonneMapper;

public class Main {

	public static void main(String[] args) {

        Personne p;
        PersonneMapper pm = PersonneMapper.getInstance();

        p = pm.find(1);
        System.out.println(p.getPrenom());


	}
	
	public void launchUi(){




		MaFrameConnexion laframe = new MaFrameConnexion();

		laframe.setLocationRelativeTo(null);
		laframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laframe.setVisible(true);
		laframe.setSize(1000, 300);
		
	}
	
	
}