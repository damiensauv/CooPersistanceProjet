
import javax.swing.*;

import Entity.IPersonne;
import Frames.MaFrameConnexion;

import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Entity.Personne;
import Oracle.Oracle;
import Persistance.Mapper.PersonneMapper;
import Persistance.UOW.UnitOfWork;

public class Main {

	public static void main(String[] args) throws SQLException {

		IPersonne p;
        PersonneMapper pm = PersonneMapper.getInstance();
		launchUi();


	}
	
	public static void launchUi(){

		MaFrameConnexion laframe = new MaFrameConnexion();

		laframe.setLocationRelativeTo(null);
		laframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laframe.setVisible(true);
		laframe.setSize(1000, 300);
		
	}
	
	
}