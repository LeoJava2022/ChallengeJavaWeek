/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tailon.prado
 */
public class Jogador {
    private String nickName;
    private ArrayList<Animal> listaCartas = new ArrayList();

    public Jogador(String nickName) {
        this.nickName = nickName;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public ArrayList getListaCartas() {
        return listaCartas;
    }
    
    public void addAnimal(Animal animal) { 
        listaCartas.add(animal);
    }

    @Override
    public String toString() {
        return "Jogador{" + "Nick Name: " + nickName + 
                ", Lista Cartas: " + listaCartas.toString() + '}';
    }
     
}
