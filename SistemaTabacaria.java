//IMPORTAÇÕES
import Produto.Produto;//importa a classe 'Produto' que está dentro do pacote 'Produto'.
import java.util.ArrayList;//importa lista que cresce conforme add objetos
import java.util.Scanner;//importa o scanner que serve para ler dados digitados pelo usuario

public class SistemaTabacaria {//declarando uma classe publica chamada 'sistemaTabacaria - publica pq pode ser acessada de qualquer lugar
    public static void main(String[] args) {//metodo principal, onde se inicia o sistema. Metodo publico, pertencente a classe, com retorno vazio, possuindo um vetor de argumentos

        Scanner scanner = new Scanner(System.in);//Scanner: tipo de Variavel -> scanner: nome da variavel -> new: cria objeto ->
        // Scanner(System.in): construtor -> System.in: entrada pelo teclado

        ArrayList<Produto> produtos = new ArrayList<>();//lista que guarda objetos do tipo Produto
        ArrayList<Venda> vendas = new ArrayList<>();//lista que guarda objetos do tipo Venda

        int opcao;//variavel do tipo inteira que guarda a opcao escolhida pelo usuario

        do{//executa primeiro, depois verifica a condição
            System.out.println("\n=========== SISTEMA VÍRUS TABACARIA ===========");//\n: quebra linha
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Registrar Venda");
            System.out.println("3 - Mostrar Relatório");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());//scanner.nextLine: lê texto -> Integer.parseInt(): converte pra inteiro e guarda a variavel 'opcao'

            switch (opcao){//estrutura de decisao baseada em valor fixo
                //cada 'case' é uma oçao do menu

                case 1:
                    System.out.println("Nome do produto: ");//pergunta ao usuario o nome do produto
                    String nome = scanner.nextLine();//lê o nome e guarda na variavel 'nome'

                    System.out.println("Valor no atacado (R$): ");//pergunta ao usuario o valor do produto no atacado
                    double atacado = Double.parseDouble(scanner.nextLine());//lê a resposta, converte esse valor em numero decimal e guarda na variavel 'atacado'

                    System.out.println("Valor de venda (R$): ");
                    double venda = Double.parseDouble(scanner.nextLine());

                    Produto produto = new Produto(nome, atacado, venda);//cria o objeto produto -> chama o construtor da classe Produto -> passa 3 parâmetros
                    produtos.add(produto);//adicionando o objeto produto na lista produtos

                    System.out.println("Produto cadastrado com sucesso!");
                    break;//encerra essa case

                case 2:
                    if(produtos.isEmpty()){//verifica se existe produto. retorna True se alista tiver vazia
                        System.out.println("Nenhum produto cadastrado!");//se a lista tiver vazia:
                        break;
                    }

                    System.out.println("\nProdutos disponiveis: ");//mostra os produtos disponiveis
                    for(int i = 0; i < produtos.size(); i++){//for: enquanto -> int i = 0: começa no indice 0 -> i < produtos.size(): 'enquanto menor que o tamanho da lista' -> i++: incrememta
                    System.out.println(i + " - " + produtos.get(i).getNome());//produtos.get(i): pega objeto na posição i -> getNome(): chama metodo da classe Produto
                }
                    System.out.println("Escolha o número do produto: ");
                    int indice = Integer.parseInt(scanner.nextLine());//lê indice escolhido e guarda qual produto foi ecilhido

                    System.out.println("Quantidade vendida: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    Venda novaVenda = new Venda(produtos.get(indice), quantidade);
                    //crie uma nova venda usando o produto escolhido da lista e a quantidade informada,
                    // depois guarde essa venda na variavel novaVenda."
                    vendas.add(novaVenda);//add o objeto vendas na lista novaVenda

                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 3://Se o usuario escolher a opçao 3, o sistema entra no modo Relatorio
                    double lucroGeral = 0;//variavel p/ armazenar o lucro total de todas as vendas
                    //começa com 0 pq vamos somar os lucros ao longo do loop

                    System.out.println("\n====RELATÓRIO====");

                    for(Venda v : vendas){//Percorre a lista de vendas -> a cada repetição, a variavel 'v' recebe uma venda da lista -> 'v' representa uma venda individual
                        System.out.println("Produto: " + v.getProduto().getNome());//“Pegue a venda → pegue o produto dessa venda → pegue o nome desse produto”
                        System.out.println("Quantidade: " + v.getQuantidade());//pega a quantidade vendida dessa venda
                        System.out.println("Lucro da venda: R$ " + v.getLucroTotal());//metodo da classe venda. valcula o lucro total da venda
                        lucroGeral += v.getLucroTotal();//Soma lucro dessa venda ao lucro total geral
                    }

                    System.out.println("\nLucro total geral: R$ " + lucroGeral);//exibe o lucro de todas as vendas
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");//se o usuario digitar 0, o sistema será encerrado
                    break;

                default://executa quando o usuario digita uma opçao invalida
                    System.out.println("Opção inválida!");//encerra o programa, sai do menu
            }
            
        }while(opcao != 0);//quando o usuario digitar 0, o sistema encerra, caso contrario, o menu continua rodando
        
        scanner.close();
    }

}
