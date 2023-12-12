/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jantarfilosofos;

/**
 *
 * @author 55649
 */
public class Garfo {
    
    private int id;
    
    private Thread filosofo;
    
    public Garfo (int id) {
        
        this.id = id;
        
        this.filosofo = null;
    }

    
    public synchronized void pegar() throws InterruptedException {
        
        if (filosofo != null){
            wait(); 
        }
        
        filosofo = Thread.currentThread(); 
    }
    
    public synchronized void soltar(){
        
        if(filosofo == Thread.currentThread()){ 
            filosofo = null;
        }
        
        notify(); 
    }
}


















