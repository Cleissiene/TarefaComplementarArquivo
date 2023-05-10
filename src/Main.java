import com.sun.webkit.SimpleSharedBufferInputStream;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        String nomeDoCliente = JOptionPane.showInputDialog("nome do cliente");

        Cliente cliente = new Cliente(nomeDoCliente);

        try {
            BufferedReader buffread = new BufferedReader(new FileReader("C:\\Users\\11513288\\Desktop\\Tarefa\\Dados.txt"));

            String linha;

            while ((linha = buffread.readLine()) != null) {
                String[] campos = linha.split(",");
                String agencia = campos[0];
                String numero = campos[1];
                double saldo = Double.parseDouble(campos[2]);

                contas.add(new Conta(agencia, numero, saldo));

            }


        } catch (IOException iox) {

            iox.getMessage();
        }

        String nomeDoBanco = JOptionPane.showInputDialog("nome do Banco");
        Banco banco = new Banco(nomeDoBanco);
        banco.setContas(contas);

        double valorTotal = banco.soma();

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("C:\\Users\\11513288\\Desktop\\Tarefa\\BancoSaldo.txt"));
            buffWriter.write("Banco " + nomeDoBanco + " possui o saldo de contas de: R$" + valorTotal);
            buffWriter.close();

        } catch (IOException iox) {

            iox.getMessage();
        }
        JOptionPane.showMessageDialog(null, "Encerrado","Finalizar",JOptionPane.PLAIN_MESSAGE);
    }
}