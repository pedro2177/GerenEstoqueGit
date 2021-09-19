package Sistema;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author phr-p
 */
public class Produto {
    private String nomeProduto;
    private double precoUnidade;
    private String unidade;
    private int quantidadeEstoque;
    
    public int pegaProduto(String valor){
        int i;
        for(i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getNomeProduto().equals(valor)){
                int x = i;
                i = produtos.size();
                return x;
            }
        }
        return -1;
    }
    
    ArrayList<Produto> produtos = new ArrayList();
    
    public Produto(){
    }
    public Produto(String nomeProduto, String unidade,int quantidadeEstoque,Double precoUnidade){
        this.nomeProduto = nomeProduto;
        this.precoUnidade = precoUnidade;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    //métodos gets
    public String getNomeProduto(){
        return this.nomeProduto;
    }
    public double getPrecoUnidade(){
        return this.precoUnidade;
    }
    public String getUnidade(){
        return this.unidade;
    }
    public int getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }
   
    //métodos sets
    public void setNomeProduto(String nomeProduto){
        
        this.nomeProduto = nomeProduto;
    }
    public double setPrecoUnidade(double precoUnidade){
        this.precoUnidade = precoUnidade;
        return precoUnidade;
    }
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
