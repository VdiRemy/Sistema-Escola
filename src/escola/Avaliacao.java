/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

/**
 *
 * @author Luma
 */
public class Avaliacao {
    protected String nome;
    protected Data dtAplic;
    protected double valor;
    
    public Avaliacao(String nome, Data dtAplic, double valor) {
        this.nome=nome;
        this.dtAplic=dtAplic;
        this.valor=valor;             
    }
}