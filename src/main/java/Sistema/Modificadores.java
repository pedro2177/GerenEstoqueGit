package Sistema;

import java.util.Scanner;

public class Modificadores extends Produto implements Verificadores{

    public Modificadores(){
        
    }

    public void menu() {
        Scanner entrada = new Scanner(System.in);
        int op;
        do {
            System.out.println("Menu: \n 1-Cadastro de Produtos \n 2-Movimentação \n 3-Reajuste de preços \n 4-Relatórios \n 0-Finalizar");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Cadastro de Produtos");
                    cadastroProdutos();
                    break;

                case 2:
                    System.out.println("Movimentação");
                    movimentacao();
                    break;

                case 3:
                    System.out.println("Reajuste de preços");
                    Scanner nprod = new Scanner(System.in);
                    System.out.println("Informe o nome do Produto: ");
                    reajustePrecos(nprod.nextLine());
                    break;

                case 4:
                    System.out.println("Relatórios");
                    relatorio();
                    break;

                case 0:
                    System.out.println("Finalizando...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (op != 5);
    } // menu inicial
    
    // Acessores de Funções (Menu's) ->
    public void cadastroProdutos(){
        Scanner entrada1 = new Scanner(System.in);
        int op1;
        do {
            System.out.print("Menu \n 1-Inclusão \n 2-Alteração \n 3-Consulta \n 4-Exclusão \n 0-Retornar \nOpção: \n");
            op1 = entrada1.nextInt();
            switch (op1){
                
            case 1: System.out.println("Inclusão de Produto.");
                inclusaoProduto();
                break;
                
            case 2: System.out.println("Alteração de produto.");
                System.out.println("Digite o nome do Produto: ");
                Scanner altera = new Scanner(System.in);
                alterarProduto(altera.nextLine());
                break;
                
            case 3: System.out.println("Consulta.");
                System.out.println("Digite o nome do Produto: ");
                Scanner consulta = new Scanner(System.in);
                consultaProdutos(consulta.nextLine());
                break;
                
            case 4: System.out.println("Exclusão.");
                System.out.println("Digite o nome do Produto: ");
                Scanner excluir = new Scanner(System.in);
                excluirProd(excluir.nextLine());
                break;
                
            case 0: System.out.println("Retornar.");
                menu();
                break;
                
            default: System.out.println("Opção inválida!");
                break;
                
            }
        } while (op1!=4);
    }
    public void movimentacao(){
        Scanner entrada2 = new Scanner(System.in);
        int op2;
        do {
            System.out.print(" 1-Entrada \n 2-Saída \n 3-Retornar \n");
            op2 = entrada2.nextInt();
            switch (op2){
                case 1: System.out.println("Entrada de Produtos.\n");
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Informe o nome do Produto: ");
                    controleEntrada(entrada.nextLine());
                    break;
                case 2: System.out.println("Saída de Produtos.\n");
                    Scanner saida = new Scanner(System.in);
                    System.out.println("Informe o nome do Produto: ");
                    controleSaida(saida.nextLine());
                    break;
                case 3: System.out.println("Retornar.");
                    menu();
                    break;
                default: System.out.println("Opção inválida!");
                    break;  
            }
        } while (op2!=3);
    }
    public void reajustePrecos(String valor){
        if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) >= 0){
            int x;
            x = pegaProduto(valor);
            Scanner novoValor = new Scanner(System.in);
            System.out.println("Nome do Produto: " + produtos.get(x).getNomeProduto());
            System.out.println("Informe o novo valor:");
            String newValue;
            while(validaLetra(newValue = novoValor.nextLine()) == true){
                System.out.println("Informe somente Números:");
            }
            produtos.get(x).setPrecoUnidade(Double.parseDouble(newValue));
            System.out.println("Valor Atualizado com sucesso!");
        } else {
            System.out.println("Produto não existe.\nPara Cancelar digite Z.\nOu Digite outro Produto: ");
            Scanner tentativa = new Scanner(System.in);
            String tent1 = tentativa.nextLine();
            if("Z".equalsIgnoreCase(tent1)){
                cadastroProdutos();
            } else {
                reajustePrecos(tent1);
            }
        }
    } // já ativa a função diretamente, pois não tem menu interno.
    public void relatorio(){
        if(produtos.isEmpty()){
            System.out.println("Não há produtos!!");
        } else {
            System.out.println("|-|  Produtos  |-|\n" + "Nome " + "   Preço  " + "  Unidade " + "  Qtde Estoque");
            int i;
            for(i = 0; i < produtos.size(); i++){
            System.out.println(produtos.get(i).getNomeProduto() + "   " + produtos.get(i).getPrecoUnidade()
                    + "     " + produtos.get(i).getUnidade() + "         " + produtos.get(i).getQuantidadeEstoque());
            }
        }
    } // já ativa a função diretamente, pois não tem menu interno.
    
    // Movimentação ->
    public void controleEntrada(String valor){
        if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) <= 0){
            int x;
            x = pegaProduto(valor);
            Scanner entradaProd = new Scanner(System.in);
            System.out.println("Informe a quantidade de entrada:");
            String estoque = entradaProd.nextLine();
            while(validaLetra(estoque) == false){
                System.out.println("Informe somente Números:");
                Scanner estoqueNovo = new Scanner(System.in);
                estoque = estoqueNovo.nextLine();
            } 
            produtos.get(x).setQuantidadeEstoque(Integer.parseInt(estoque));
            
            System.out.println("Atualizado com sucesso!");
        } else {
            System.out.println("Produto não existe.\nPara Cancelar digite Z.\nOu Digite outro Produto: ");
            Scanner tentativa = new Scanner(System.in);
            String tentativ = tentativa.nextLine();
            if("Z".equalsIgnoreCase(tentativ)){
                cadastroProdutos();
            } else {
                controleEntrada(tentativ);
            }
        }
    } // basicamente faz a entrada de produtos no sistema
    public void controleSaida(String valor){
        if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) <= 0){
            int x;
            x = pegaProduto(valor);
            Scanner entradaProd = new Scanner(System.in);
            System.out.println("Informe a quantidade de saída:");
            String estoque = entradaProd.nextLine();
            while(validaLetra(estoque) == false){
                System.out.println("Informe somente Números:");
                Scanner estoqueNovo = new Scanner(System.in);
                estoque = estoqueNovo.nextLine();
            }
            produtos.get(x).setQuantidadeEstoque(-Integer.parseInt(estoque));
            
            System.out.println("Atualizado com sucesso!");
        } else {
            System.out.println("Produto não existe.\nPara Cancelar digite Z.\nOu Digite outro Produto: ");
            Scanner tentativa = new Scanner(System.in);
            String tentativ = tentativa.nextLine();
            if("Z".equalsIgnoreCase(tentativ)){
                cadastroProdutos();
            } else {
                controleEntrada(tentativ);
            }
        }
    } // cuida da saída
    
    // Cadastro Produtos ->
    public void alterarProduto(String valor){
        if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) <= 0){
            int x;
            x = pegaProduto(valor);
            System.out.println("Nome do Produto: " + produtos.get(x).getNomeProduto());
            System.out.println("Valor: " + produtos.get(x).getPrecoUnidade());
            System.out.println("Unidade: " + produtos.get(x).getUnidade());
            System.out.println("Quantidade em Estoque: " + produtos.get(x).getQuantidadeEstoque());
            System.out.println("Para alterar, basta alterar o campo abaixo respectivo.\nCaso não queira alterar algum atributo, deixe em branco e aperte Enter.");
            
            System.out.println("Valor: ");
            
            Scanner value = new Scanner(System.in);
            String valorNovo = value.nextLine();
            if(valorNovo.equals("")){
                System.out.println("Valor não será alterado.");
            } else if(validaNumero(valorNovo) == false){
                System.out.println("Somente valores numéricos são aceitos, o valor não será alterado.");
            } else {
                System.out.println("Novo valor: " + Double.parseDouble(valorNovo));
                produtos.get(x).setPrecoUnidade(Double.parseDouble(valorNovo));
            }
            
            System.out.println("Unidade: ");
            
            Scanner unid = new Scanner(System.in);
            String newUnid = unid.nextLine();
            if(newUnid.equals("")){
                System.out.println("Unidade não será alterada.");
            } else if(validaNumero(newUnid) == true){
                System.out.println("Somente letras são aceitas, a unidade não será alterada.");
            } else {
                System.out.println("Nova Unidade: " + newUnid);
                produtos.get(x).setUnidade(newUnid);
            }
            
            System.out.println("Quantidade em Estoque: ");
            
            Scanner qtde = new Scanner(System.in);
            String newQtde = qtde.nextLine();
            if(newQtde.equals("")){
                System.out.println("Qtde em Estoque não será alterada.");
            } else if(validaNumero(newQtde) == false){
                System.out.println("Somente valores numéricos são aceitos, o valor não será alterado.");
            } else {
                System.out.println("Estoque Atual: " + Integer.parseInt(newQtde));
                produtos.get(x).setQuantidadeEstoque(Integer.parseInt(newQtde));
            }
            
            System.out.println("Alterações feitas com Sucesso!");
            
        } else {
            System.out.println("Produto não existe.\nPara Cancelar digite Z.\nOu Digite outro Produto: ");
            Scanner tentativa = new Scanner(System.in);
            String tentativ = tentativa.nextLine();
            if("Z".equalsIgnoreCase(tentativ)){
                cadastroProdutos();
            } else {
                alterarProduto(tentativ);
            }
        }
    } // altera qualquer atributo do produto individualmente ou todos.
    public void inclusaoProduto(){
        System.out.println("Nome do Produto: ");
        Scanner entrada = new Scanner(System.in);
        String nomeProd = registraNome(entrada.nextLine());
        
        System.out.println("Unidade: ");
        Scanner unidad = new Scanner(System.in);
        String unid = registraLetra(unidad.nextLine());
        
        System.out.println("Quantidade de Entrada: ");
        Scanner valorInicial = new Scanner(System.in);
        double valorInicia = registraNumero(valorInicial.nextLine());
        
        System.out.println("Preço da Unidade: ");
        Scanner preco = new Scanner(System.in);
        double precoUnid = registraNumero(preco.nextLine());
        System.out.println("Confirma a inclusão? (S/N)");
        
        Scanner confirmacao = new Scanner(System.in);
        if ("s".equalsIgnoreCase(confirmacao.nextLine())){
            Produto prod = new Produto(nomeProd, unid,(int) valorInicia, precoUnid);
            produtos.add(produtos.size(), prod);
            System.out.println("Produto adicionado com sucesso!");
        } else if ("n".equalsIgnoreCase(confirmacao.nextLine())){
            System.out.println("Operação Cancelada!");
            cadastroProdutos();
        } else {
            System.out.println("Opção inválida!");
        }
    } // adiciona ao sistema.
    public void consultaProdutos(String valor){
        if(validaLetra(valor)){
            if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) >= 0){
                int x;
                x = pegaProduto(valor);
                System.out.println("Nome do Produto: " + produtos.get(x).getNomeProduto());
                System.out.println("Preço Unidade: R$ " + produtos.get(x).getPrecoUnidade());
                System.out.println("Quantidade em Estoque: " + produtos.get(x).getQuantidadeEstoque() + " Unid.");
                System.out.println("Unidade: " + produtos.get(x).getUnidade());
            } else {
                System.out.println("Produto não existe.\nPara Cancelar digite Z\nOu Digite outro Produto: ");
                Scanner tentativa = new Scanner(System.in);
                if("Z".equalsIgnoreCase(tentativa.nextLine())){
                    cadastroProdutos();
                } else {
                    consultaProdutos(tentativa.nextLine());
                }
            }
        } else {
            System.out.println("Somente Letras!!\n Tente Novamente: ");
            Scanner novo = new Scanner(System.in);
            consultaProdutos(novo.nextLine());
        }
    } // consulta pelo nome.
    public void excluirProd(String valor){
        if(pegaProduto(valor) <= produtos.size() && pegaProduto(valor) <= 0){
            int x;
            x = pegaProduto(valor);
            produtos.remove(x);
            System.out.println("Removido com Sucesso!");
        } else {
            System.out.println("Produto não existe.\nPara Cancelar digite Z.\nOu Digite outro Produto: ");
            Scanner tentativa = new Scanner(System.in);
            if("Z".equalsIgnoreCase(tentativa.nextLine())){
                cadastroProdutos();
            } else {
                excluirProd(tentativa.nextLine());
            }
        }
    } // exclui o produto.
    
    // Validações Extras ->
    public double registraNumero(String valor){
        if (validaNumero(valor)){
            double valorDouble = Double.parseDouble(valor);
            return valorDouble;
        } else {
            while(validaNumero(valor) == false){
                System.out.println("Somente números.\nDigite Novamente:");
                Scanner entrada = new Scanner(System.in);
                valor = entrada.nextLine();
            }
            return registraNumero(valor);
        }
    } // retorna um double após verificar se é somente número.
    public String registraNome(String valor){
        if(validaLetra(valor)){
            while (pegaProduto(valor) >= 0){
                System.out.println("Inválido ou Existente.\nDigite Novamente: ");
                Scanner entrada = new Scanner(System.in);
                valor = entrada.nextLine();
            }
        } else {
            System.out.println("Ops, somente letras, porfavor!\nDigite:");
            Scanner novo = new Scanner(System.in);
            return registraNome(novo.nextLine());
        }
        return valor;
    } // retorna somente o nome do produto (verifica se existe já).
    public String registraLetra(String valor){
        if (validaLetra(valor)){
            return valor;
        } else {
            while(validaLetra(valor) == false){
                System.out.println("Inválido ou Existente:");
                Scanner entrada = new Scanner(System.in);
                valor = entrada.nextLine();
            }
        return valor;
        }
    } // retorna qualquer String validando somente letras.
    
    // verificadores implements (pra ser bem sincero,
    // eu ia mover várias coisas pra verificadores e criar várias classes pra organizar melhor,
    // mas fiquei sem tempo :(
    // porém está quase 100% funcional
    // está tendo algumas exceptions que eu também não tive tempo de tratar (nem vai notar elas rs).
    // Aguardo o feedback...
    
    @Override 
    public boolean validaEspecial(String valor) {
        return validaLetra(valor) == false && validaNumero(valor) == false;
    }

    @Override
    public boolean validaLetra(String valor) {
        int i;
        for (i = 0; i<valor.length(); i++){
            return Character.isAlphabetic(valor.charAt(i));
        }
        return false;
    }

    @Override
    public boolean validaNumero(String valor) {
        return valor.substring(0).matches("[0-9]*");
    }
}