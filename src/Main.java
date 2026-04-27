import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        gerenciarTarefas gerenciar = new gerenciarTarefas();
        gerenciar.carregarTarefas();

        int opcao;

        do {
            System.out.println("\n Menu");
            System.out.println("\n1 - Adicionar Tarefas");
            System.out.println("\n2 - Listar Tarefas");
            System.out.println("\n3 - Concluir Tarefas");
            System.out.println("\n4 - Remover Tarefas");
            System.out.println("\n0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        gerenciar.adicionarTarefa(desc);

                        break;

                case 2:
                    System.out.print("Tarefas: ");
                    gerenciar.listarTarefas();
                    break;

                case 3:
                    System.out.print("Indice de Tarefas: ");
                    int iConcluir = sc.nextInt();
                    gerenciar.concluirTarefa(iConcluir);
                    break;

                case 4:
                    System.out.print("Indice de Tarefas: ");
                    int iRemover = sc.nextInt();
                    gerenciar.removerTarefa(iRemover);

                case 0:
                    System.out.println("Saindo...");
                    gerenciar.salvarTarefas();
                    break;

            }
        }while (opcao != 0);
        sc.close();
    }
}