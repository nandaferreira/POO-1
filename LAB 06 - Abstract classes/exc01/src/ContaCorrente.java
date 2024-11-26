public class ContaCorrente {
    private float saldo;
    private int estado; // 1 = conta ativa, 2 = conta inativa
    private int numConta;
    private int senha;

    public ContaCorrente(float valor, int numero, int password){
        this.saldo = valor;
        this.estado = 1; //conta ativa
        this.numConta = numero;
        this.senha = password;

    }

    public boolean debitaValor(float valor, int password){
        if(password != senha){
            return(false); //senha deve ser inválida
        }
        if(estado != 1){
            return(false);
        }
        if(valor <= 0){
            return (false); //valor tem que ser > 0
        }
        if(valor > saldo){
            return(false);
        }

        saldo -= valor; // saldo = saldo - valor
        if(saldo == 0){
            estado = 2; // torna a conta inativa;
        }
        return (true);
    }

    public void debitaValor(float valor){
        saldo -= valor; // saldo = saldo - valor
    }

    public float getSaldo(int password){
        if(senha == password){
            return saldo;
        }else{
            return -1; // indicando que houve problema na senha
        }
    }

    public void creditaValor(int password, float valor){
        if(senha == password){
            saldo += valor; // saldo = saldo + valor
        }
    }

    protected int getEstado(int password){
        if(senha == password){
            return estado;
        }else{
            return -1;
        }
    }

    protected void setEstado(int password, int e){
        if(senha == password){
            estado = e;
        }
    }

    protected boolean isSenha(int password){
        if(senha == password){
            return(true);
        }else{
            return false;
        }
    }

    public String imprimirDados(){
        String status;
        if(estado == 1){
            status = "Conta ativa";
        }
        if(estado == 2){
            status = "Conta inativa";
        }else{status = "Entre com 1 para válido e 2 para inválido";}
        return("Número da conta:" + numConta +
                "\nEstado: " + status +
                "\nSaldo disponível: " + getSaldo(senha));
    }
}

/*A conta corrente comum tem que se tornar inativa se durante a sua movimentação o saldo
for igual a 0. Nesse caso, a conta não pode receber mais lançamentos e nem ser reativada novamente.
Essa regra está implementada no metdo debitaValor() da classe ContaCorrente
 */
