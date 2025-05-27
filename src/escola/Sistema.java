/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luma
 */
public class Sistema {
    private List<Professor> profs;
    private List<Aluno> alunos;

    public Sistema() {
        this.profs = new ArrayList<>();
        this.alunos= new ArrayList<>();
    }

    /***************************************************/

    public void novoProf(Professor p) {
        this.profs.add(p);
    }
    public void novoAluno(Aluno a){
        this.alunos.add(a);
    }

    /***************************************************/

    public Professor encontrarProfessor(String cpf) {
        for (Professor p : this.profs) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    /***************************************************/
    
    public Aluno encontrarAlunoCpf(String cpf) {
        for (Aluno a : this.alunos) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }
        }
        return null;
    }
    
    /***************************************************/
    public Aluno encontrarAlunoMat(String mat) {
        for (Aluno a : this.alunos) {
            if (a.getMat().equals(mat)) {
                return a;
            }
        }
        return null;
    }
    
    
    /***************************************************/

    public void listarProfs() {
        if (this.profs.size() > 0) {
            System.out.println("Professores cadastrados:");
            for (Professor p : this.profs) {
                System.out.println("* " + p);
            }
        }
        else {
            System.out.println("Nenhum professor cadastrado até o momento.");
        }
    }
    /***************************************************/

    public void listarAlunos(){
        if (this.alunos.size() > 0) {
            System.out.println("alunos cadastrados:");
            for (Aluno a : this.alunos) {
                System.out.println("* " + a);
            }
        }
        else {
            System.out.println("Nenhum aluno cadastrado até o momento.");
        }
    }
    /***************************************************/
    public void listarTurmas() {
        