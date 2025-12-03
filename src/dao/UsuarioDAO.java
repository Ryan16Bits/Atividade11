package dao;

import model.Usuario;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UsuarioDAO {
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome,email,senha) VALUES (?,?,?)";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getEmail());
            stmt.setString(3,usuario.getSenha());

            stmt.executeUpdate();

            System.out.println("Usuário salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getEmail());
            stmt.setString(3,usuario.getSenha());
            stmt.setInt(4,usuario.getIdUsuario());

            stmt.executeUpdate();

            System.out.println("Usuário atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void deletar(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,idUsuario);

            stmt.executeUpdate();

            System.out.println("Usuário deletado!");
        } catch (Exception e) {
            System.out.println("Erro ao deleter: " + e.getMessage());
        }
    }

    public Usuario buscarPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setInt(1, idUsuario);

            return new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getDate("dataCadastro").toLocalDate()
            );
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return null;
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
