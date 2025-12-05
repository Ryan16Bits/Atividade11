package dao;

import model.Direct;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DirectDAO {
    public void enviarMensagem(Direct direct) {
        String sql = "INSERT INTO direct (fkIdRemetente,fkIdDestinatario,mensagem) VALUES (?,?,?)";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,direct.getFkIdRemetente());
            stmt.setInt(2,direct.getFkIdDestinatario());
            stmt.setString(3,direct.getMensagem());

            stmt.executeUpdate();

            System.out.println("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao enviar: " + e.getMessage());
        }
    }

    public List<Direct> listarMensagens(int fkIdRemetente, int fkIdDestinatario) {
        List<Direct> lista = new ArrayList<>();
        String sql = "SELECT * FROM direct WHERE fkIdRemetente = ? AND fkIdDestinatario = ?";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,fkIdRemetente);
            stmt.setInt(2,fkIdDestinatario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Direct d = new Direct(
                        rs.getInt("idDirect"),
                        rs.getInt("fkIdRemetente"),
                        rs.getInt("fkIdDestinatario"),
                        rs.getString("mensagem")
                );
                lista.add(d);
            }
        } catch (Exception e) {
            System.out.println("Erro ao lister: " + e.getMessage());
        }
        return lista;
    }
}
