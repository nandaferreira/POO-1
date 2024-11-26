public class Main {
    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente(5000, 148, 1234);
        ContaCorrente conta2 = new ContaCorrente(6000, 135,5678);


       conta1.debitaValor(1500);
       conta1.imprimirDados();
    }
}