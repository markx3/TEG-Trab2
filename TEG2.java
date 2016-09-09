/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author mrk
 */
public class TEG2 {
   
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int vertMax = 0, v1 = 0, v2 = 0, v3 = 0;
        Scanner in = new Scanner(new FileReader(args[0]));
        while(in.hasNext()) {
            v1 = in.nextInt();
            v2 = in.nextInt();
            in.nextLine();
            if (v1 > vertMax) vertMax = v1;
            if (v2 > vertMax) vertMax = v2;
         }  /* Encontra a quantidade de vértices */
        System.out.println("vertMax = " + vertMax + "\n");
        /* Inicializa um array de LinkedLists */
        LinkedList<Integer> [] list = new LinkedList[vertMax];
       
        /* Para percorrer novamente o arquivo */
        in = new Scanner(new FileReader(args[0]));
        while(in.hasNext()) {
            v1 = in.nextInt();
            v2 = in.nextInt();
            v3 = in.nextInt();
            
            /* Inicializa a linked list */
            if (list[v1-1] == null) list[v1-1] = new LinkedList<>();
            if (list[v2-1] == null) list[v2-1] = new LinkedList<>();
            
            /* Adiciona à lista o elemento lido. */
            while(v3 != 0) {
                if (!list[v1-1].contains(v2)) list[v1-1].add(v2);
                if (!list[v2-1].contains(v1)) list[v2-1].add(v1);
                
		v3--;
            }   
        }
        
	/* Printa a lista encadeada */
        System.out.println("Lista encadeada:");
        for(int i = 0; i < vertMax; i++) {
            System.out.println("Vértice " + (i+1) + ": " + list[i]);
        } 
        
        System.out.print("\nVetor de adjacência:\nV: ");
        
        int V[] = new int[vertMax]; /* Inicializa vetor V */
        int wMax = 0;
        for (int i = 0; i < vertMax; i++) {
            wMax += list[i].size();
            V[i] = list[i].size();
            System.out.print(V[i] + " ");
        } System.out.println();
        int W[] = new int[wMax]; /* Inicializa vetor W com o tamanho necessário */
        
        int j = 0;
        int i = 0;
        int k = 0;
        
        /* Adiciona os elementos ao vetor W */
        for (i = 0; i < vertMax; i++) {
            for (j = 0; j < list[i].size(); j++) {
                W[k++] = list[i].get(j);
            }
        }
        
        System.out.print("W: ");
        for (i = 0; i < wMax; i++) System.out.print(W[i] + " ");
        System.out.println();
    }
    
}

