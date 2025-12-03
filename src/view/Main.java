package view;

import dao.CurtidaDAO;
import dao.DirectDAO;
import dao.PostagemDAO;
import dao.UsuarioDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CurtidaDAO cdao = new CurtidaDAO();
        DirectDAO ddao = new DirectDAO();
        PostagemDAO pdao = new PostagemDAO();
        UsuarioDAO udao = new UsuarioDAO();

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
    }
}