package banco;
public class ContaCorrente extends ContaPrincipal{
    public void consultar_dados(String tit, int num, int sen){
        System.out.print("Digite aqui a sua senha: ");
        int senh = ler.nextInt();
        if(senh==sen){
        System.out.println("Nome: "+tit+"\nNúemro da Conta: "+num);
        }else{
            System.out.println("Senha incorreta!");
        }
    }
   
}
