package com.mycompany.bancojava;

import java.util.Random;

/**
 *
 * @author Lucas
 */
public class ContaBanco {

    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    //construtor
    
    public void ContaBanco(){
        this.setSaldo(0);
        this.setStatus(false);
        
    }

   

    //Metodo para mostra os atributos
    public void atributes() {
        System.out.println("----------------------------");
        System.out.println("Número da conta: " + numConta);
        System.out.println("Tipo da conta: " + tipo);
        System.out.println("Dono da conta: " + dono);
        System.out.println("Saldo da conta: " + saldo);
        System.out.println("Status da conta: " + status);
    }

    //Metodos
    public void AbrirConta(String tipo, String dono) {
        this.setStatus(true);
        this.setDono(dono);
        this.criaNumero();

        if ("cc".equals(tipo)) {
            this.setTipo(tipo);
            this.setSaldo(50.00f);

        } else if ("cp".equals(tipo)) {
            this.setTipo(tipo);
            this.setSaldo(150.00f);
        }

    }

    public void depositar(float valor) {
        if (this.getStatus() == false) {
            System.out.println("Não pode depositar sem a conta estar aberta");
        } else {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Sr(a)" + this.getDono() + " Depositou: " + valor);
        }
    }

    public void sacar(float valor) {
        if (this.getStatus() == false) {
            System.out.println("Não é possível sacar se não tiver uma conta aberta");
        }
        if (this.getSaldo() == 0) {
            System.out.println("Você esta sem saldo, não tem o que sacar");

        } else if (this.getSaldo() < 0) {
            System.out.print("Você está negativado, revise suas pendencias");
        } else {
            this.setSaldo(this.getSaldo() - valor);
        }

        System.out.println("Sr(a)" + this.getDono() + " Sacou: " + valor);
        System.out.println("Seu saldo atual é: " + this.getSaldo());

    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Não pode fechar a conta com saldo");
        } else if (this.getSaldo() < 0) {
            System.out.println("Não é possivél fechar conta com saldo negativo");
        } else {
            this.dono = " ";
            this.numConta = 0;
            this.status = false;
            this.setTipo("");
            System.out.println("Sua conta foi fechada!");
        }
    }

    public void pagarMensal() {
        if (this.getStatus() == false) {
            System.out.println("A conta não está aberta");
        }

        if (this.getSaldo() == 0) {
            System.out.println("Não é possivel pagar mensalidade sem saldo");
        } else if(this.getSaldo() < 12){
            System.out.println("não é possivel pagar sem saldo");
            
        } if ("cc".equals(this.getTipo())) {
                float valor = this.getSaldo() - 12;
                this.setSaldo(valor);
            } else {
                float valor = this.getSaldo() - 20;
                this.setSaldo(valor);
            }
    }

    // Metodos getters e setters
    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return this.saldo;

    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = (saldo.matches("[0-9.]+") == false ? 0f : Float.parseFloat(saldo));
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void criaNumero() {
        Random numero = new Random();
        this.numConta = numero.nextInt(100);

    }

}
