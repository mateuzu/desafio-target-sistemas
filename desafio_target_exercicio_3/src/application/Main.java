package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Faturamento;
import service.impl.FaturamentoServiceImpl;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "resources/dados.json";
        File arquivo = new File(caminhoArquivo);
        StringBuilder json = new StringBuilder();

        try(BufferedReader leitor = new BufferedReader(new FileReader(arquivo))){
            String linha;
            
            while((linha = leitor.readLine()) != null){
                json.append(linha.trim());
            }
            
        } catch (IOException e) {
            e.printStackTrace();;
        }

        List<Faturamento> dados = new ArrayList<>();
        String[] registros = json.toString().split("\\},\\{");

        for(String registro : registros) {
        	
            int dia = 0;
            double valor = 0.0;
            
            String [] partes = registro.split(",");
            
            for(String parte : partes){
                if(parte.contains("\"dia\"")){
                    dia = Integer.parseInt(parte.split(":")[1].trim());
                } else if (parte.contains("\"valor\"")){
                    valor = Double.parseDouble(parte.split(":")[1].replace("}", "").replace("]", "").trim());
                }
            }
            
            dados.add(new Faturamento(dia, valor));
        }

        FaturamentoServiceImpl service = new FaturamentoServiceImpl();
        
        for(int i = 0; i < dados.size(); i++){
            service.menorFaturamento(dados);
            service.maiorFaturamento(dados);
            service.mediaFaturamento(dados);
            service.diasAcima(dados);
        }

        System.out.println("*********** Relatório ************");
        System.out.println("\nMenor faturamento: R$ " + String.format("%.2f", service.getMenorFaturamento()));
        System.out.println("Maior faturamento: R$ " + String.format("%.2f", service.getMaiorFaturamento()));
        System.out.println("Média faturamento: R$ " + String.format("%.2f", service.getMediaFaturamento()));
        System.out.println("Dias com o faturamento acima da média: " + service.getDiasAcima());

    }
}
