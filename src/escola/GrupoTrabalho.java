/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

/**
 *
 *A classe GrupoTrabalho armazena o array de alunos do grupo e a nota do grupo. Há um
método para verificar se um aluno pertence ao grupo, dado seu cpf.
 */
public class GrupoTrabalho {
    private Aluno[] alunos;
    private double nota;

    public GrupoTrabalho(Aluno[] alunos, double nota) {
        this.alunos = alunos;
        this.nota = nota;
    }

    public boolean alunoNoGrupo(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public double getNota() {
        return nota;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }
}

