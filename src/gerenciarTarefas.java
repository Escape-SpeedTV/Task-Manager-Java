import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.io.*;


public class gerenciarTarefas {
        ArrayList<tarefa> tarefas = new ArrayList<>();

        public void adicionarTarefa(String descricao){
            tarefas.add(new tarefa(descricao));
        }
        public void listarTarefas(){
            if(tarefas.isEmpty()){
                System.out.println("Nenhuma tarefa cadastrada.");
                return;
            }
            for (int i = 1; i < tarefas.size(); i++){
                System.out.println(i + " - " + tarefas.get(i));
            }
        }

        public void concluirTarefa(int index){
            if (index >= 0 && index < tarefas.size()){
                tarefas.get(index).marcarComoConcluida();
            } else {
                System.out.println("índice inválido.");
            }
        }

        public void removerTarefa(int index){
            if (index >= 0 && index < tarefas.size()){
                tarefas.remove(index);
            }else{
                System.out.println("índice inválido.");
            }
        }


        public void salvarTarefas(){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("tarefatxt.txt"));

                for(tarefa t : tarefas){
                    writer.write(t.descricao + ";" + t.concluida);
                    writer.newLine();
                }
                writer.close();
            }catch (IOException e){
                System.out.println("Error ao salvar tarefas");
            }
        }

        public void carregarTarefas() {
            try{
                File file = new File("tarefatxt.txt");

                if(!file.exists()) return;

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String linha;

            while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(";");

                    tarefa t = new tarefa(partes[0]);
                    t.concluida = Boolean.parseBoolean(partes[1]);

                    tarefas.add(t);
                }
                reader.close();

            }catch(IOException e){
                System.out.println("Erro ao carregar tarefas.");
            }
        }
}

