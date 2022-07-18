package br.com.bytebank.banco.teste;

import java.util.Random;

public class TesteArray {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[r.nextInt(15)+1];
        for(int i=0;i<valores.length;i++){
            int x = r.nextInt(50) + 1;
            System.out.println(x);
        }
    }
}
