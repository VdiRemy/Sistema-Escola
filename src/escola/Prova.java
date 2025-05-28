package escola;
import java.util.ArrayList;
public class Prova extends Avaliacao {
    private int nQuestoes;  
    private ArrayList<AlunoProva> notas;

    public Prova(String nome,Data dtAplic,double valor, int nQuestoes, ArrayList<AlunoProva>notas) {
        super(nome,dtAplic,valor);
        this.nQuestoes = nQuestoes;
        this.notas=notas;
    }
    
    @Override
    public double nota(String cpf) {
        for (AlunoProva ap : this.notas) {
            if (ap.getAluno().getCpf().equals(cpf)) {
                return ap.notaTotal() / this.nQuestoes; // Retorna a média das notas
            }
        }
        return 0.0; // Retorna 0 se o aluno não for encontrado
    }
}


