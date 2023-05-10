import java.util.List;

public class Banco {

    private  String nome;

    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Double soma(){
        double valor = 0;
        for(Conta conta : contas){
            valor += conta.getSaldo();
            //valor = valor + conta.getSaldo(); - alternativa de linha de codigo
        }
         return valor;
    }

}
