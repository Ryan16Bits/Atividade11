package view;

import dao.CurtidaDAO;
import dao.DirectDAO;
import dao.PostagemDAO;
import dao.UsuarioDAO;
import model.Postagem;
import model.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurtidaDAO cdao = new CurtidaDAO();
        DirectDAO ddao = new DirectDAO();
        PostagemDAO pdao = new PostagemDAO();
        UsuarioDAO udao = new UsuarioDAO();
        boolean fechar = false;

        while (fechar == false) {
            System.out.println("=== MINITOK ===");
            System.out.println("Sejá bem-vindo ao MINITOK! O que deseja fazer?");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Criar postagem");
            System.out.println("6 - Listar postagens de um usuário");
            System.out.println("7 - Excluir postagem");
            System.out.println("8 - Curtir postagem");
            System.out.println("9 - Descurtir postagem");
            System.out.println("10 - Mostrar quantidade de postagens");
            System.out.println("11 - Enviar direct");
            System.out.println("12 - Listar direct de dois usuários");
            System.out.println("13 - Sair");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1) {
                System.out.println("===CRIAR USUÁRIO===");

                System.out.println("Digite o nome do usuário: ");
                String nome = sc.nextLine();

                System.out.println("-------------");
                System.out.println("Digite o email do usuário: ");
                String email = sc.nextLine();

                System.out.println("-------------");
                System.out.println("Digite a senha do usuário: ");
                String senha = sc.nextLine();

                System.out.println("-------------");
                Usuario novo = new Usuario(nome,email,senha);
                udao.salvar(novo);
            } else if (escolha == 2) {
                System.out.println("===LISTAR USUÁRIO===");

                System.out.println("ID - Nome - Email - Senha - Data de Cadastro");
                System.out.println("-------------");
                for (Usuario u : udao.listarTodos()) {
                    System.out.println(u.getIdUsuario() + " - " + u.getNome() + " - " + u.getEmail() + " - " + u.getSenha() + " - " + u.getDataCadastro());
                }
            } else if (escolha == 3) {
                System.out.println("===ATUALIZAR USUÁRIO===");

                System.out.println("Digite o ID do usuário: ");
                int idUsuarioAtualizar = sc.nextInt();
                sc.nextLine();

                System.out.println("-------------");
                System.out.println("Novo nome: ");
                String novoNome = sc.nextLine();

                System.out.println("-------------");
                System.out.println("Novo email: ");
                String novoEmail = sc.nextLine();

                System.out.println("-------------");
                System.out.println("Novo senha: ");
                String novaSenha = sc.nextLine();

                System.out.println("-------------");
                Usuario usuarioAtualizado = new Usuario(idUsuarioAtualizar,novoNome,novoEmail,novaSenha);
                udao.atualizar(usuarioAtualizado);
            } else if (escolha == 4) {
                System.out.println("===EXCLUIR USUÁRIO===");

                System.out.println("Digite o ID do usuário: ");
                int idUsuarioDeletar = sc.nextInt();
                sc.nextLine();

                udao.deletar(idUsuarioDeletar);
            } else if (escolha == 5) {
                System.out.println("===CRIAR POSTAGEM===");

                System.out.println("Digite o ID do usuário: ");
                int fkIdUsuario = sc.nextInt();
                sc.nextLine();

                System.out.println("-------------");
                System.out.println("Insira o conteúdo da postagem: ");
                String conteudo = sc.nextLine();

                System.out.println("-------------");
                Postagem novo = new Postagem(fkIdUsuario,conteudo);
                pdao.salvar(novo);
            } else if (escolha == 6) {
                System.out.println("===LISTAR POSTAGENS DE UM USUÁRIO===");

                System.out.println("Digite o ID do usuário: ");
                int fkIdUsuario = sc.nextInt();
                sc.nextLine();

                for (Postagem p : pdao.listarPorUsuario(fkIdUsuario)) {
                    System.out.println(p.getIdPostagem() + " - " + p.getFkIdUsuario() + " - " + p.getConteudo() + " - " + p.getDataPostagem());
                }
            } if (escolha == 7) {
                System.out.println("===DELETAR POSTAGEM===");

                System.out.println("Digite o ID da postagem: ");
                int idPostagemDeletar = sc.nextInt();
                sc.nextLine();

                pdao.deletar(idPostagemDeletar);
            } if (escolha == 8) {
                System.out.println("===CURTIR POSTAGEM===");

                System.out.println("Digite a postagem: ");
                int fkIdPostagem = sc.nextInt();

                System.out.println("-------------");
                System.out.println("Digite o ID do usuário: ");
                int fkIdUsuario = sc.nextInt();

                if (cdao.verificarSeJaCurtiu(fkIdPostagem, fkIdUsuario) == true) {
                    System.out.println("O usuário já curtiu a postagem!");
                }
                {
                    System.out.println("O usuário não curtiu");
                    cdao.curtir(fkIdPostagem,fkIdUsuario);
                }
            }

            else {
                fechar = true;
            }
        }
    }
}

