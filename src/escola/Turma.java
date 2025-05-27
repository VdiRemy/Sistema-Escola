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
    
    public Turma(String nome,int Ano,int sem,Professor prof,ArrayList<Aluno>alunos,ArrayList<Avaliacao>avs) {
        this.nome=nome;
        this.ano=Ano;
        this.sem=sem;
        this.prof=prof;
        this.alunos=alunos;
        this.avs=new ArrayList<>();
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
    
            
}