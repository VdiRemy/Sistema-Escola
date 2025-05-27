/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

import java.util.ArrayList;

/**
 *
 * @author Luma
 */
public class Turma {
    private String nome;
    private int ano;
    private int sem;
    private Professor prof;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avs;
    
    public Turma(String nome,int Ano,int sem,Professor prof,ArrayList<Aluno>alunos,ArrayList<Avaliacao>avs) {
        this.nome=nome;
        this.ano=Ano;
        this.sem=sem;
        this.prof=prof;
        this.alunos=alunos;
        this.avs=avs;
    }

    Turma(String nome, int ano, int sem, Professor prof, ArrayList<Aluno> alunosTurma, Prova prova) {
        this.nome = nome;
        this.ano = ano;
        this.sem = sem;
        this.prof = prof;
        this.alunos = alunosTurma;
        this.avs = new ArrayList<>();
        this.avs.add(prova);
    }

    public void medias() {
        System.out.println("Médias da turma " + this.nome + " (" + this.ano + "/" +this.sem + ")" + " :");
        for (Aluno a : this.alunos) {
            AlunoProva ap = new AlunoProva(a, new ArrayList<>());
            for (Avaliacao av : this.avs) {
                ap.getNotas().add(av.getNota(a));
            }
            System.out.println("Média do aluno " + a.getNome() + ": " + ap.media());
        }
        System.out.println("Média da turma " + this.nome + ": " + mediaTurma());
    }
}
