/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jantarfilosofos;

import java.util.Random;

public class Filosofo implements Runnable {

    private static final int tempoMaximoPensando = 1000; 

    private int id;
    private int tempoComendo; 
    private Garfo meuGarfo, garfoVizinho;

    private Random rand = new Random();

    public Filosofo(int id, int tempoComendo, Garfo esquerda, Garfo direita) {
        this.id = id;
        this.tempoComendo = tempoComendo;
        this.meuGarfo = esquerda;
        this.garfoVizinho = direita;
    }

    private void pensar() {
        System.out.println("Filósofo " + id + " está PENSANDO");

        try {
            int tempoPensando = rand.nextInt(tempoMaximoPensando);
                
            Thread.sleep(tempoPensando);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pegarGarfos() {
        try {
            if (rand.nextInt(2) == 1) {
                meuGarfo.pegar();
                System.out.println("Filósofo " + id + " PEGOU o 1° garfo (ESQUERDO).");
                garfoVizinho.pegar();
                System.out.println("Filósofo " + id + " PEGOU o 2° garfo (DIREITO).");
            } else {
                garfoVizinho.pegar();
                System.out.println("Filósofo " + id + " PEGOU o 1° garfo (DIREITO).");
                meuGarfo.pegar();
                System.out.println("Filósofo " + id + " PEGOU o 2° garfo (ESQUERDO).");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void soltarGarfos() {
        if (rand.nextInt(2) == 1) {
            meuGarfo.soltar();
            System.out.println("Filósofo " + id + " LARGOU o 1° garfo (ESQUERDO).");
            garfoVizinho.soltar();
            System.out.println("Filósofo " + id + " LARGOU o 2° garfo (DIREITO).");
        } else {
            garfoVizinho.soltar();
            System.out.println("Filósofo " + id + " LARGOU o 1° garfo (DIREITO).");
            meuGarfo.soltar();
            System.out.println("Filósofo " + id + " LARGOU o 2° garfo (ESQUERDO).");
        }
    }

    private void comer() throws InterruptedException {
        
            System.out.println("Filósofo " + id + " está COMENDO");
            
            Thread.sleep(tempoComendo);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                pegarGarfos();
                comer();
                soltarGarfos();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
