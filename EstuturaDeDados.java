import java.util.Scanner;


class Listas {
    Ponto inicio;
    Ponto fim;

    public Listas() {
        inicio = null;
        fim = null;
    }
}

class Ponto {
    int dados;
    Ponto proximo;

    public Ponto(int dados) {
        this.dados = dados;
        this.proximo = null;
    }
}

public class Main {
    public static void criar(Listas lista) {
        lista.inicio = null;
        lista.fim = null;
    }

    public static void consulta(Listas lista) {
        Ponto p = lista.inicio;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.dados + " ->> ");
            p = p.proximo;
        }
        System.out.println("NULL");
    }

    public static void inserir(Listas lista, int a) {
        Ponto novo = new Ponto(a);
        Ponto atual = lista.inicio;
        Ponto anterior = null;

        while (atual != null && atual.dados < a) {
            anterior = atual;
            atual = atual.proximo;
        }

        novo.proximo = atual;

        if (anterior != null) {
            anterior.proximo = novo;
        } else {
            lista.inicio = novo;
        }
    }

    public static void remover(Listas lista, int a) {
        Ponto atual = lista.inicio;
        Ponto anterior = null;

        while (atual != null && atual.dados != a) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (anterior != null) {
            if (atual != null) {
                anterior.proximo = atual.proximo;
                atual = null;
                System.out.println("Valor Removido");
            } else {
                System.out.println("Valor não encontrado");
            }
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public static void alterar(Listas lista, int a, int b) {
        Ponto atual = lista.inicio;
        Ponto anterior = null;

        while (atual != null && atual.dados != a) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (anterior != null) {
            if (atual != null) {
                atual.dados = b;
                System.out.println("Alterado Com Sucesso! ;-D");
            } else {
                System.out.println("Valor Indisponível... :-(");
            }
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public static boolean vazia(Listas lista) {
        return (lista.inicio == null);
    }

    public static void reset(Listas lista) {
        Ponto auxiliar = lista.inicio;
        if (auxiliar != null) {
            while (auxiliar != null) {
                lista.inicio = auxiliar.proximo;
                auxiliar = null;
                auxiliar = lista.inicio;
            }
            System.out.println("Todos os elementos foram removidos!");
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Listas listacriada = new Listas();
        int valor1, op, valor2;
        criar(listacriada);

        System.out.println("ESTRUTURA DE DADOS");
        while (true) {
            System.out.println("\n 1 - Inserir Elemento");
            System.out.println(" 2 - Mostrar Lista");
            System.out.println(" 3 - Alterar Elemento da Lista");
            System.out.println(" 4 - Remover Elemento da Lista");
            System.out.println(" 5 - Sair");
            System.out.print("\n Digite o Número da Opção: ");



            while (!scanner.hasNextInt()) {
                System.out.println(" \n ===== ENTRADA INVALIDA. ===== \n");
                System.out.println(" Digite um número inteiro: ");
                scanner.next(); // Descarta a entrada inválida
            }

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print(" Digite um Valor numérico: ");
                    valor1 = scanner.nextInt();
                    inserir(listacriada, valor1);
                    break;
                case 2:
                    if (vazia(listacriada)) {
                        System.out.println("Lista Vazia...");
                    } else {
                        consulta(listacriada);
                    }
                    break;
                case 3:
                    System.out.print("Valor Para Ser Alterado: ");
                    valor1 = scanner.nextInt();
                    System.out.print("Novo Valor: ");
                    valor2 = scanner.nextInt();
                    alterar(listacriada, valor1, valor2);
                    break;
                case 4:
                    System.out.print("Valor: ");
                    valor1 = scanner.nextInt();
                    remover(listacriada, valor1);
                    break;
                case 5:
                    reset(listacriada);
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
