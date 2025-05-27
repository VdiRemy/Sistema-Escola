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

public class Prova extends Avaliacao {
    private int nQuestoes;  
    private ArrayList<AlunoProva> notas;

    public Prova(String nome,Data dtAplic,double valor, int nQuestoes, ArrayList<AlunoProva>notas) {
        super(nome,dtAplic,valor);
        this.nQuestoes = nQuestoes;
        this.notas=notas;
    }
}


