/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bancojava;

/**
 *
 * @author Lucas
 */
public class TestandoBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco();
        ContaBanco c2 = new ContaBanco();
        
        c1.AbrirConta("cc","José de anchieta" );
        c1.depositar(100);
        c1.sacar(150);
        c1.fecharConta();
        
        
        c1.atributes();
        
        
       
        
               
        
        
    }
    
    
    
}
