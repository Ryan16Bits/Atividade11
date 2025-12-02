package dao;

import model.Postagem;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {
    public void salvar(Postagem postagem) {
        String sql = "INSERT INTO postagens (fkIdUsuario,conteudo) VALUES (?,?);";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,postagem.getFkIdUsuario());
            stmt.setString(2,postagem.getConteudo());

            stmt.executeUpdate();

            System.out.println("Postagem salva com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void atualizar(Postagem postagem) {
        String sql = "UPDATE postagem SET fkIdUsuario = ?, conteudo = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,postagem.getFkIdUsuario());
            stmt.setString(2,postagem.getConteudo());

            stmt.setInt(4,postagem.getIdPostagem());

            stmt.executeUpdate();

            System.out.println("Postagem atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void deletar(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,idUsuario);

            stmt.executeUpdate();

            System.out.println("Usuário deletado!");
        } catch (Exception e) {
            System.out.println("Erro ao deleter: " + e.getMessage());
        }
    }

    public void buscarPorId(int idUsuario) {
        String sql = "SELECT FRPM usuarios WHERE id = ?";
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getDate("dataCadastro").toLocalDate()
                );
                lista.add(u);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }
}
}
