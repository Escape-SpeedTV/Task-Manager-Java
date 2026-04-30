import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class tela {

    public static void main(String[] args) {

        gerenciarTarefas gerenciador = new gerenciarTarefas();
        gerenciador.carregarTarefas();


        JFrame frame = new JFrame("📝 Gerenciador de Tarefas");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //Painel Superior

        JPanel painelTopo = new JPanel(new FlowLayout());
        JTextField campo = new JTextField(20);
        JButton BotaoAdicionar = new JButton("Adicionar");
        painelTopo.add(new JLabel("Tarefa"));
        painelTopo.add(campo);
        painelTopo.add(BotaoAdicionar);
        frame.add(painelTopo, BorderLayout.NORTH);

        //Painel Central

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        frame.add(scroll, BorderLayout.CENTER);

        //Painel Inferior

        JPanel painelBaixo = new JPanel(new FlowLayout());
        JTextField campoIndice = new JTextField(5);
        JButton botaoConcluir = new JButton("Concluir");
        JButton botaoRemover = new JButton("Remover");
        JButton botaoDesmarcar = new JButton("Desmarcar");
        painelBaixo.add(new JLabel("Índice: "));
        painelBaixo.add(campoIndice);
        painelBaixo.add(botaoConcluir);
        painelBaixo.add(botaoRemover);
        painelBaixo.add(botaoDesmarcar);

        frame.add(painelBaixo, BorderLayout.SOUTH);

        //Painel Action
    }
}
