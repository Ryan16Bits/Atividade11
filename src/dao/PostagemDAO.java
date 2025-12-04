package dao;

import model.Postagem;
import model.Usuario;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {
    public void salvar(Postagem postagem) {
        String sql = "INSERT INTO postagens (fkIdUsuario,conteudo) VALUES (?,?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,postagem.getFkIdUsuario());
            stmt.setString(2,postagem.getConteudo());

            stmt.executeUpdate();

            System.out.println("Postagem salva com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao postar: " + e.getMessage());
        }
    }

    public void atualizar(Postagem postagem) {
        String sql = "UPDATE postagens SET fkIdUsuario = ?, conteudo = ? WHERE idPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,postagem.getFkIdUsuario());
            stmt.setString(2,postagem.getConteudo());

            stmt.setInt(3,postagem.getIdPostagem());

            stmt.executeUpdate();

            System.out.println("Postagem atualizada!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void deletar(int idPostagem) {
        String sql = "DELETE FROM postagens WHERE idPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,idPostagem);

            stmt.executeUpdate();

            System.out.println("Postagem deletada!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public Postagem buscarPorId(int idPostagem) {
        String sql = "SELECT * FROM postagens WHERE idPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1,idPostagem);

            return new Postagem(
                    rs.getInt("idPostagem"),
                    rs.getInt("fkIdUsuario"),
                    rs.getString("conteudo")
                    );
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return null;
    }

    public List<Postagem> listarPorUsuario(int fkIdUsuario) {
        List<Postagem> lista = new ArrayList<>();
        String sql = "SELECT * FROM postagens WHERE fkIdUsuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,fkIdUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Postagem p = new Postagem(
                        rs.getInt("idPostagem"),
                        rs.getInt("fkIdUsuario"),
                        rs.getString("conteudo")
                );
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }
}