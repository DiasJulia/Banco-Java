package banco;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
public class Banco {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Tipo de conta: \n[ 1 ] Corrente\n[ 2 ] Poupança\nOpção: ");
        int opcao = ler.nextInt();
        if(opcao==1){
            ContaCorrente conta = new ContaCorrente();
            System.out.print("Digite o nome do titular: ");
            String nome = ler.next();
            conta.setTitular(nome);
            System.out.print("Digite a sua senha (Somente números): ");
            int senha = ler.nextInt();
            conta.setSenha(senha);
            conta.setNum(rand.nextInt(111111111));
            while(true){
            System.out.print("Operações: \n[ 1 ] Sacar\n[ 2 ] Depositar\n[ 3 ] Consultar Saldo\n[ 4 ] Alterar senha\n[ 5 ] Consultar dados"
                    + "\n[ 6 ] Transferência\n[ 7 ] Pagar Boleto\n[ 8 ] Sair\nOpção: ");
            int opcao2=ler.nextInt();
            switch (opcao2) {
                case 1:
                    System.out.print("Digiteo valor a ser sacado: ");
                    double valor=ler.nextDouble();
                    conta.sacar(valor);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valor2=ler.nextDouble();
                    conta.depositar(valor2);
                    break;
                case 3:
                    conta.consultar_saldo();
                    break;
                case 4:
                    conta.alterar_senha();
                    break;
                case 5:
                    String tit = conta.getTitular();
                    int num = conta.getNum();
                    int sen = conta.getSenha();
                    conta.consultar_dados(tit, num, sen);
                    break;
                case 6:
                    System.out.print("Valor a ser transferido: ");
                    double valor3 = ler.nextDouble();
                    System.out.print("Conta que recebrá o valor: ");
                    int nume=ler.nextInt();
                    conta.transferencia(valor3);
                    break;
                case 7:
                    double sal=conta.getSaldo();
                    int sen1 = conta.getSenha();
                    conta.pagar_boleto(sen1, sal);
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
            if (opcao2==8){
                break;
            }
            }}else if(opcao==2){
            ContaPoupança conta = new ContaPoupança();
            System.out.print("Digite o nome do titular: ");
            String nome = ler.next();
            conta.setTitular(nome);
            System.out.print("Digite a sua senha(Somente números): ");
            int senha = ler.nextInt();
            conta.setSenha(senha);
            System.out.print("Dia mês e ano do seu nascimento(dia/mês/ano): ");
            String nascimento = ler.next();
            conta.setNascimento(nascimento);
            conta.setNum(rand.nextInt(111111111));
            while(true){
            System.out.print("Operações: \n[ 1 ] Sacar\n[ 2 ] Depositar\n[ 3 ] Consultar Saldo\n[ 4 ] Alterar senha\n[ 5 ] Consultar dados"
                    + "\n[ 6 ] Transferência\n[ 7 ] Rendimento\n[ 8 ] Sair\nOpção: ");
            int opcao2=ler.nextInt();
            switch (opcao2) {
                case 1:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valor=ler.nextDouble();
                    conta.sacar(valor);
                    break;
                    
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valor2=ler.nextDouble();
                    conta.depositar(valor2);
                    break;
                case 3:
                    conta.consultar_saldo();
                    break;
                case 4:
                    conta.alterar_senha();
                    break;
                case 5:
                    String tit = conta.getTitular();
                    int num = conta.getNum();
                    int sen = conta.getSenha();
                    String nasc = conta.getNascimento();
                    conta.consultar_dados(tit, num, sen, nasc);
                    break;
                case 6:
                    System.out.print("Digite o valor a ser transferido: ");
                    double valor3 = ler.nextDouble();
                    System.out.print("Digite a conta do felizardo: ");
                    int nume=ler.nextInt();
                    conta.transferencia(valor3);
                    break;
                case 7:
                    double sal1 = conta.getSaldo();
                    conta.rendimento(sal1);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
            if (opcao2==8){
                break;
            }
        }
        System.out.println("Obrigado por utilizar de nosso sistema! XD");
    }
}
}
