public class tarefa {
    String descricao;
    boolean concluida;

    public tarefa(String descricao){
        this.descricao = descricao;
        this.concluida = false;
    }

    public void marcarComoConcluida(){
        this.concluida = true;
    }

    public void desmarcarAtividade(){
        this.concluida = false;
    }

    @Override
    public String toString(){
        return (concluida ? "[✔] " : "[ ] ") + descricao;
    }
}
