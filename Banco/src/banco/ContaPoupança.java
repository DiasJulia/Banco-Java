package banco;
public class ContaPoupança extends ContaPrincipal{
    public void rendimento(double sal1){
        double prox = sal1 + (sal1*0.5/100);
        System.out.println("O valor do rendimento é: "+ prox );
    }
    public void consultar_dados(String tit, int num, int sen, String nasc){
        System.out.print("Digite aqui a sua senha: ");
        int senh = ler.nextInt();
        if(senh==sen){
        System.out.println("Nome: "+tit+"\nNúemro da Conta: "+num+"\nData de Nascimento: "+nasc);
        }else{
            System.out.println("Senha incorreta!");
        }
    }
}
