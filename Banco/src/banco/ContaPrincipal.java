package banco;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class ContaPrincipal {
    Scanner ler = new Scanner(System.in);
    Random rand = new Random();
    private int senha, num;
    private double saldo;
    private String titular;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate nascimento = LocalDate.parse("01/01/0001", formato);
    
    
//gets e sets
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;}
    
    public int getNum() {
        return num;}
    
    public void setNum(int num) {
        this.num = num;}
    
    public double getSaldo() {
        return saldo;}
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;}
    
    public String getTitular() {
        return titular;}
    
    public void setTitular(String titular) {
        this.titular = titular;}
    public void setNascimento(String data1){
        LocalDate data = LocalDate.parse(data1, formato); 
        System.out.println(formato.format(data));}
    public String getNascimento(){
        String data = formato.format(this.nascimento);
        return data;}
//Funções
    public void sacar(double valor){
        System.out.print("Digite sua senha: ");
        int senh = ler.nextInt();
        if(senh==this.senha){           
            if (this.saldo>=valor){
                this.saldo-=valor;
                System.out.println("Operação realizada com sucesso\nNovo saldo: "+this.saldo);
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("Senha incorreta!");
        }
    }
    public void depositar(double valor){
        System.out.print("Digite aqui a sua senha: ");
        int senh = ler.nextInt();
        if(senh==this.senha){      
            this.saldo+=valor;
            System.out.println("Valor de " + valor + " depositado com sucesso\nNovo saldo: R$"+this.saldo);
        }else{
            System.out.println("Senha incorreta!");
        }
    }
    public void consultar_saldo(){
        System.out.print("Digite a sua senha: ");
        int senh = ler.nextInt();
        if(senh==this.senha){      
            System.out.println("Saldo atual: R$"+ this.saldo);
        }else {
            System.out.println("Senha incorreta!");
        }
    }
    public void alterar_senha() {
        System.out.print("Digite a sua senha: ");
        int senh = ler.nextInt();
        if(senh==this.senha){
            System.out.print("Digite a nova senha: ");
            int nov_senh = ler.nextInt();
            System.out.print("confirme a nova senha: ");
            int conf_senh = ler.nextInt();
            if(nov_senh==conf_senh){
                this.senha=nov_senh;
                System.out.println("Operação realizada com sucesso!");
            }else{
                System.out.println("As duas senha não conferem! Verifique se você as digitou corretamente!");
            }
        }else{
            System.out.println("Senha incorreta!");
        }
        
    
    }  
    public void transferencia(double valor){
        System.out.print("Digite a sua senha: ");
        int senh = ler.nextInt();
        if(senh==this.senha){
            if(valor<=this.saldo){
                this.saldo-=valor;
                System.out.format("Tranferência no valor de %.2f realizada com sucesso\n", valor);
            }else {
                System.out.println("Saldo insuficiente!");
            }
        }else{
            System.out.println("Senha incorreta!");
        }     
    }
    public void pagar_boleto(int sen, double sal){
        System.out.print("Digite aqui a sua senha: ");
        int senh = ler.nextInt();
        if(senh==sen){
            System.out.print("Digite aqui o código de barras ou digite 589 e coloque-o sob o feixe de luz: ");
            int codbarras = ler.nextInt();
            if(codbarras==589){
                codbarras=rand.nextInt(1111111111);
            }
            int valu = rand.nextInt(111);
            System.out.println("Valor: "+valu);
            System.out.print("Está correto?(s/n) ");
            String conf = ler.next();
            if(conf.equals("s")){
                if(valu<=sal){
                    System.out.println("Boleto no valor de  R$" + valu + " pago com sucesso!");
                    this.saldo-=valu;
                }else{
                    System.out.println("Saldo insuficiente!");
                }
            }else{
                System.out.println("Reinicie a operação e veja se está correto! Se o problema persistir ligue para nossa central: 4002-8922 :)");
            }
        }else{
            System.out.println("Senha incorreta");
        }
    }
}


