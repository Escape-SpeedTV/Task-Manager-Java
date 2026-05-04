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
        JButton botaoAdicionar = new JButton("Adicionar");
        painelTopo.add(new JLabel("Tarefa"));
        painelTopo.add(campo);
        painelTopo.add(botaoAdicionar);
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
        botaoAdicionar.addActionListener(e ->{
            String texto = campo.getText();
            if (!texto.trim().isEmpty()){
                gerenciador.adicionarTarefa(texto);
                gerenciador.salvarTarefas();
                atualizarArea(area, gerenciador);
                campo.setText("");
            }else {
                JOptionPane.showMessageDialog(frame, "Digite uma tarefa!");
            }
        });

        botaoConcluir.addActionListener(e ->{
            try{
                int index = Integer.parseInt(campoIndice.getText());
                gerenciador.concluirTarefa(index);
                gerenciador.salvarTarefas();
                atualizarArea(area, gerenciador);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Indice Inválido");
            }
        });

        botaoRemover.addActionListener(e -> {
            try {
                int index = Integer.parseInt(campoIndice.getText());
                gerenciador.removerTarefa(index);
                gerenciador.salvarTarefas();
                atualizarArea(area, gerenciador);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Índice inválido!");
            }
        });

        botaoDesmarcar.addActionListener(e -> {
            try {
                int index = Integer.parseInt(campoIndice.getText());
                gerenciador.desmarcarT(index);
                gerenciador.salvarTarefas();
                atualizarArea(area, gerenciador);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Índice inválido!");
            }
        });

        //Atualizar a tela

        atualizarArea(area, gerenciador);
        frame.setVisible(true);
    }

    public static void atualizarArea(JTextArea area, gerenciarTarefas gerenciador){
        area.setText("");
        for (int i = 0; i < gerenciador.tarefas.size(); i++){
            area.append(i + " - " + gerenciador.tarefas.get(i) + "\n");
        }
    }
}
