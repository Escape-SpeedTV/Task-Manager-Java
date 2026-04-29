import javax.swing.*;
import java.awt.event.ActionListener;

public class tela {

    public static void main(String[] args){

        gerenciarTarefas gerenciador = new gerenciarTarefas();
        gerenciador.carregarTarefas();


        JFrame frame = new JFrame("Gerenciador de Tarefas");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField campoIndice = new JTextField();
        campoIndice.setBounds(50, 340, 50, 30);
        frame.add(campoIndice);


        JButton botaoConcluir = new JButton("Concluir");
        botaoConcluir.setBounds(110, 340, 100, 30);
        frame.add(botaoConcluir);

        JTextField campo = new JTextField();
        campo.setBounds(50, 30, 200, 30);

        JButton desmarcar = new JButton("Desmarcar");
        desmarcar.setBounds(330, 340, 100, 30);
        frame.add(desmarcar);

        JButton botao = new JButton("Adicionar");
        botao.setBounds(260, 30, 100, 30);

        JTextArea area = new JTextArea();
        area.setBounds(50, 80, 310, 250);
        botaoConcluir.addActionListener(e -> {
            try{
                int index = Integer.parseInt(campoIndice.getText());

                gerenciador.concluirTarefa(index);
                atualizarArea(area, gerenciador);
                gerenciador.salvarTarefas();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Indice inválido!");
            }
        });

        desmarcar.addActionListener(e -> {
            try {
                int index = Integer.parseInt(campoIndice.getText());
                gerenciador.desmarcarT(index);
                atualizarArea(area, gerenciador);
                gerenciador.salvarTarefas();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Indice Inválido!");
            }
        });

        JButton botaoRemover = new JButton("Remover");
        botaoRemover.setBounds(220, 340, 100, 30);
        frame.add(botaoRemover);

        botaoRemover.addActionListener(e ->{
            try {
                int index = Integer.parseInt(campoIndice.getText());
                gerenciador.removerTarefa(index);
                atualizarArea(area, gerenciador);
                gerenciador.salvarTarefas();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Índice inválido!");
            }
        });

        frame.add(campo);
        frame.add(botao);
        frame.add(area);

        botao.addActionListener(e -> {
            String texto = campo.getText();

            if (!texto.isEmpty()){
                gerenciador.adicionarTarefa(texto);

                atualizarArea(area, gerenciador);

                campo.setText("");

            }
        });

        atualizarArea(area, gerenciador);

        frame.setVisible(true);


    }

    public static void atualizarArea(JTextArea area, gerenciarTarefas gerenciador) {
        area.setText("");

        for (int i = 0; i < gerenciador.tarefas.size(); i++) {
            area.append(i + " - " + gerenciador.tarefas.get(i) + "\n");
        }
    }

}
