/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jantarfilosofos;

import java.util.ArrayList;

/**
 *
 * @author 55649
 */
public class JantarFilosofos {

    public static void main(String[] args) throws InterruptedException {

        int totalFilosofos = 5;
        int tempoComendo = 1000; 

        ArrayList<Garfo> garfos = new ArrayList<Garfo>();
        ArrayList<Filosofo> filosofos = new ArrayList<Filosofo>();
        
        for (int i = 0; i < totalFilosofos; i++) { 
            garfos.add(new Garfo (i));
             
        }
        
        for (int i = 0; i < totalFilosofos; i++){
            
            int garfoProximo;
            
            if(i == totalFilosofos - 1){
                garfoProximo = 0;
            
            }else{
                garfoProximo = i + 1;
            
            }
            
            filosofos.add(new Filosofo(i, tempoComendo, garfos.get(i), garfos.get(garfoProximo)));
        }
        
        for(Filosofo f: filosofos){ 
            new  Thread(f).start();
        }
    }
}
