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



