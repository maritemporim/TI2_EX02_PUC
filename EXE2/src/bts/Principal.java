package bts;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n--- MENU ÁLBUNS ---");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Album> lista = dao.listar();
                    for (Album a : lista) {
                        System.out.println(a);
                    }
                    break;

                case 2:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Ano de lançamento: ");
                    int ano = sc.nextInt();
                    dao.inserir(new Album(titulo, artista, ano));
                    break;

                case 3:
                    System.out.print("ID do álbum a atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Novo artista: ");
                    String novoArtista = sc.nextLine();
                    System.out.print("Novo ano de lançamento: ");
                    int novoAno = sc.nextInt();
                    dao.atualizar(new Album(idAtualizar, novoTitulo, novoArtista, novoAno));
                    break;

                case 4:
                    System.out.print("ID do álbum a excluir: ");
                    int idExcluir = sc.nextInt();
                    dao.excluir(idExcluir);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}

