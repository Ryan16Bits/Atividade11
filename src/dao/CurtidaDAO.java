package dao;

import model.Curtida;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurtidaDAO {
    public void curtir(int fkIdPostagem, int fkIdUsuario) {
        String sql = "INSERT INTO curtidas (fkIdPostagem,fkIdUsuario) VALUES (?,?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdPostagem);
            stmt.setInt(2, fkIdUsuario);

            stmt.executeUpdate();

            System.out.println("Postagem!");
        } catch (Exception e) {
            System.out.println("Erro ao curtir: " + e.getMessage());
        }
    }

    public void descutir(int fkIdPostagem, int fkIdUsuario) {
        String sql = "DELETE FROM curtidas WHERE fkIdPostagem = ?, fkIdUsuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdPostagem);
            stmt.setInt(2, fkIdUsuario);

            stmt.executeUpdate();

            System.out.println("Postagem descurtida!");
        } catch (Exception e) {
            System.out.println("Erro ao descurtir: " + e.getMessage());
        }
    }

    public boolean verificarSeJaCurtiu(int fkIdPostagem, int fkIdUsuario) {
        String sql = "SELECT fkIdPostagem, fkIdUsuario FROM curtidas WHERE fkIdPostagem = ?, fkIdUsuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1, fkIdPostagem);
            stmt.setInt(2, fkIdUsuario);

            if (rs.next()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println("Erro ao verificar: " + e.getMessage());
        }
        return false;
    }

    public int contarCurtidas(int fkIdPostagem) {
        String sql = "SELECT COUNT(*) AS likes FROM curtidas WHERE fkIdPostagem = ?";
        int contagem = 0;

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1, fkIdPostagem);

            if (rs.next()) {
                contagem = rs.getInt("likes");
            }
            return contagem;
        } catch (Exception e) {
            System.out.println("Erro ao verificar: " + e.getMessage());
        }
        return 0;
    }
}
