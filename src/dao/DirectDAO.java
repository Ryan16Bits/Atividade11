package dao;

import model.Direct;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public Direct listarMensagens(int fkIdRemetente, int fkIdDestinatario) {
        String sql = "SELECT * FROM direct WHERE fkIdRemetente = ?, fkIdDestinatario = ?";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1,fkIdRemetente);
            stmt.setInt(2,fkIdDestinatario);

            return new Direct(
                    rs.getInt("idDirect"),
                    rs.getInt("fkIdRemetente"),
                    rs.getInt("fkIdDestinatario"),
                    rs.getString("mensagem"),
                    rs.getDate("dataEnvio").toLocalDate()
            );
        } catch (Exception e) {
            System.out.println("Erro ao lister: " + e.getMessage());
        }
        return null;
    }
}
