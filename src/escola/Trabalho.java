/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

/**
 *
 * @author Luma
 */

//tem que herdar de Avaliacao
class Trabalho extends Avaliacao {
    /**
     * Trabalho é uma avaliação que possui um número máximo de integrantes no grupo
     * e um array com objetos da classe GrupoTrabalho para cada grupo que fez este
     * trabalho. A classe GrupoTrabalho armazena o array de alunos do grupo e a nota
     * do grupo. Há um método para verificar se um aluno pertence ao grupo, dado seu
     * cpf.
     */
    private int nIntegrantes;
    private GrupoTrabalho[] grupos;

    public Trabalho(String nome, Data dtAplic, double valor, int nIntegrantes, GrupoTrabalho[] grupos) {
        super(nome, dtAplic, valor);
        this.nIntegrantes = nIntegrantes;
        this.grupos = grupos;
    }

    @Override
    public double nota(String cpf) {
        for (GrupoTrabalho grupo : grupos) {
            if (grupo.alunoNoGrupo(cpf)) {
                return grupo.getNota();
            }
        }
        return 0; // Retorna 0 se o aluno não estiver em nenhum grupo
    }

    public Aluno getAluno(String cpf) {
        for (GrupoTrabalho grupo : grupos) {
            for (Aluno aluno : grupo.getAlunos()) {
                if (aluno.getCpf().equals(cpf)) {
                    return aluno; // Retorna o aluno se encontrado no grupo
                }
            }
        }
        return null; // Retorna null se o aluno não for encontrado
    }
}
