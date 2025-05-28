package escola;
import java.util.ArrayList;
import java.util.List;
public class AlunoProva{
    private Aluno aluno;
    private List<Integer> notas;
    
    public AlunoProva(Aluno a,List<Integer> notas){
        this.aluno=a;
        this.notas=new ArrayList<>(notas);

    }
    public double notaTotal() {
        double total = 0;
        for (int nota : this.notas) {
            total += nota;
        }
        return total;
    }

    public Aluno getAluno() {
        return aluno;
    }
}



