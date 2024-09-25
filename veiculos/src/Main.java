import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Carro polo = new Carro("VW", "Polo", 2024, 4);
        Moto biz = new Moto("honda", "Biz", 2009, 80);
        Caminhao caminhao = new Caminhao("Volvo", "xxxxxxxx40", 2017, 20);
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        veiculos.add(caminhao);
        veiculos.add(biz);
        veiculos.add(polo);
        boolean control = true;

        while (control) {
            List<Veiculo> veiculosDisponiveis = veiculos.stream().filter(veiculo -> veiculo.isAlugado() == false).toList();
            List<Veiculo> veiculosAlugados = veiculos.stream().filter(veiculo -> veiculo.isAlugado() == true).toList();
            System.out.println("Insira a opção desejada");
            System.out.println("1 - devolver veiculos");
            System.out.println("2 - alugar veiculos");
            System.out.println("3 - Listar veiculos");
            System.out.println("4 - Criar veiculo");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    if (veiculosAlugados.isEmpty() == false) {
                        veiculosAlugados.stream().forEach((veiculo) -> System.out.println(veiculos.indexOf(veiculo) + " " +  veiculo.toString()));
                        System.out.println("Selecione o veiculo:");
                        int x = sc.nextInt();
                        veiculos.get(x).devolver();                    
                        System.out.println("Veiculo devolvido");
                    } else {
                        System.out.println("Não tem veiculo a ser devolvido");
                    }
                    break;
                case 2:
                    veiculosDisponiveis.stream().forEach((veiculo) -> System.out.println(veiculos.indexOf(veiculo) + " " +  veiculo.toString()));
                    System.out.println("Selecione o veiculo:");
                    int index = sc.nextInt();
                    if (index >= 0 && index < veiculosDisponiveis.size()) {
                        System.out.println("quantos dias:");
                        int dias = sc.nextInt();
                        System.out.println(veiculosDisponiveis.get(index).calcularValorAluguel(dias));
                        System.out.println("Deseja alugar? ----- 1 SIM  || 2 NAO");
                        int desejaAlugar = sc.nextInt();
                        if (desejaAlugar == 1) {
                            veiculosDisponiveis.get(index).alugar();
                            System.out.println("Veiculo alugado");
                        }
                    }
                    
                    break;
                case 3:
                    veiculos.forEach(veiculo -> System.out.println(veiculo.toString()));
                    break;
                case 4:
                    System.out.println("Insira o tipo de veículo que deseja criar:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.println("3 - Caminhão");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Insira a marca:");
                            String marca = sc.next();
                            System.out.println("Insira o modelo:");
                            String modelo = sc.next();
                            System.out.println("Insira o ano:");
                            int ano = sc.nextInt();
                            System.out.println("Insira a quantidade de portas:");
                            int qtdPortas = sc.nextInt();
                            veiculos.add(new Carro(marca, modelo, ano, qtdPortas));
                            break;
                        case 2:
                            System.out.println("Insira a marca:");
                            String marcaMoto = sc.next();
                            System.out.println("Insira o modelo:");
                            String modeloMoto = sc.next();
                            System.out.println("Insira o ano:");
                            int anoMoto = sc.nextInt();
                            System.out.println("Insira as cilindradas:");
                            int cilindradas = sc.nextInt();
                            veiculos.add(new Moto(marcaMoto, modeloMoto, anoMoto, cilindradas));
                            break;
                        case 3:
                            System.out.println("Insira a marca:");
                            String marcaCaminhao = sc.next();
                            System.out.println("Insira o modelo:");
                            String modeloCaminhao = sc.next();
                            System.out.println("Insira o ano:");
                            int anoCaminhao = sc.nextInt();
                            System.out.println("Insira a capacidade de carga em tonelada:");
                            int carga = sc.nextInt();
                            veiculos.add(new Caminhao(marcaCaminhao, modeloCaminhao, anoCaminhao, carga));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    control = false;
                    break;
            }
        }

        sc.close();
    }
}
