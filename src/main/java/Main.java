import Entity.IPersonne;
import Frames.MaFrameConnexion;
import Persistance.Mapper.PersonneMapper;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        IPersonne p;
        PersonneMapper pm = PersonneMapper.getInstance();
        launchUi();
    }

    public static void launchUi() {

        MaFrameConnexion laframe = new MaFrameConnexion();

        laframe.setLocationRelativeTo(null);
        laframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        laframe.setVisible(true);
        laframe.setSize(1000, 300);
    }
}