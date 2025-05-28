package escola;
import java.util.ArrayList;
public class Turma {
    private String nome;
    private int ano;
    private int sem;
    private Professor prof;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avs;
    
    public String getNomeTurma() {
        return nome;
    }
    public int getAno() {
        return ano;
    }
    public int getSem() {
        return sem;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public Professor getProfessor() {
        return prof;
    }
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avs;
    }
    
    public Turma(String nome,int Ano,int sem,Professor prof,ArrayList<Aluno>alunos,ArrayList<Avaliacao>avs) {
        this.nome=nome;
        this.ano=Ano;
        this.sem=sem;
        this.prof=prof;
        this.alunos=alunos;
        this.avs=new ArrayList<>();
    }

    public Turma(String nome, int ano, int sem, Professor prof, ArrayList<Aluno> alunosTurma, Prova prova) {
        this.nome = nome;
        this.ano = ano;
        this.sem = sem;
        this.prof = prof;
        this.alunos = alunosTurma;
        this.avs = new ArrayList<>();
        this.avs.add(prova);
    }

    public Turma(String nome, int ano, int sem, Professor prof, ArrayList<Aluno> alunosTurma, Trabalho trabalho) {
        this.nome = nome;
        this.ano = ano;
        this.sem = sem;
        this.prof = prof;
        this.alunos = alunosTurma;
        this.avs = new ArrayList<>();
        this.avs.add(trabalho);
    }

    public Turma(String nome, int ano, int sem, Professor prof,ArrayList<Aluno>alunosTurma) {
        this.nome = nome;
        this.ano = ano;
        this.sem = sem;
        this.prof = prof;
        this.alunos = alunosTurma;
        this.avs = new ArrayList<>();
    }
    public void medias() {
        System.out.println("Médias da turma " + this.nome + " (" + this.ano + "/" +this.sem + "):");
        double mediaTurma = 0;
        double somaNotas = 0;
        int totalAlunos = this.alunos.size();
        for (Aluno a : this.alunos) {
            String notas = "";
            double total = 0;
            int count = 0;
            for (Avaliacao av : this.avs) {
                double nota = av.nota(a.getCpf());
                notas += nota + " ";
                total += nota;
                count++;
            }
            System.out.println(a.getNome() + " (Matricula : " + a.getMat() + "): " + notas + "= " + total);
            somaNotas += total;

        }
        if (totalAlunos > 0) {
            mediaTurma = somaNotas / totalAlunos;
        }
        System.out.println("Média da turma: " + mediaTurma);
    }

    public void adicionarAvaliacao(Avaliacao av) {
        this.avs.add(av);
    }

}