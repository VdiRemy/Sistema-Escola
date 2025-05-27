/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escola;

/**
 *
 * @author Luma
 */
public class Aluno extends Pessoa {
    private String mat;
    public Aluno(String nome, String cpf, String mat) {
        super(nome, cpf);
        this.mat = mat;
    }
    @Override
    public String toString() {
        return this.nome + " (mat: " + this.mat + ")";
    }
    public String getMat() {
        return mat;
    }
    public String Nome() {
        return nome;
    }
}
