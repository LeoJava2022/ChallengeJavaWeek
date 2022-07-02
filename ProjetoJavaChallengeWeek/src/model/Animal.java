/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tailon.prado
 */
public class Animal {
    private String nome;
    private double forca;
    private double defesa;
    private double velocidade;
    
    public Animal(String nome, double forca, double defesa, double velocidade) {
        this.nome = nome;
        this.forca = forca;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "\nAnimal{ Nome: " + nome + " | Força: " + forca + " | Defesa: " + 
                defesa + " | Velocidade: " + velocidade + "}"; 
    }
      
}
