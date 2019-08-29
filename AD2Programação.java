package ad2programação;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import sun.misc.IOUtils;

public class AD2Programação {

    public static void main(String[] args) throws FileNotFoundException, IOException {
           
         int numLinhas=0;
         int sobrevivente = 0;
         String []nomes = new String[30]; //TIVE DIFICULDADE EM DECLARAR UM VETOR SEM NÚMERO DE MÉMORIA ESPECIFICO, ENTÃO DECLAREI UM COM 30.
         int pN,pK,n,k;
         int sobrev=0;
         String nome = " ";
         String nK;
         int pulo=0;
         
        
        
        InputStream arq = new FileInputStream("Arquivo.txt"); //AQUI VOCÊ DEVE ADICIONAR O ARQUIVO A SER LIDO, POIS COMO PEDIDO, ENVIAREI OS ARQUIVOS .JAVA E A AD IMPRESSA SOMENTE!!
        InputStreamReader arqu = new InputStreamReader(arq);
        BufferedReader arquivo = new BufferedReader(arqu);
            
        OutputStream s = new FileOutputStream("saida-Arquivo.txt");//AQUI VOCÊ DEVE ADICIONAR O ARQUIVO DE TEXTO VAZIO PARA TESTES!!
        OutputStreamWriter sai = new OutputStreamWriter(s);
        BufferedWriter saida = new BufferedWriter(sai);
        
        String ler = arquivo.readLine();
        while ((ler != null) && (!ler.equals("FIM")) ) {
                numLinhas++;
                nomes[numLinhas] = ler; 
                ler = arquivo.readLine();
        }
        arquivo.close();
        
        pN = numLinhas+2;
        pK = numLinhas+3;
        RetornaNeK retorna = new RetornaNeK(pN,pK);//O OUTRO ARQUIVO .JAVA CONTÉM O CÓDIGO DA CLASS "RetornaNeK"
        n = retorna.retornarN();
        k = retorna.retornarK();
        
        for (int i =1;i<numLinhas+1;i++){ 
                if (nomes[i]!=null) {
                    sobrevivente++;
                }
        }
        sobrev=sobrevivente;
        
        while (sobrev != 1 ){
            int cont= 1;
            while (cont<=numLinhas){
                if (nomes[cont]!= null){
                    pulo++;
                    if(pulo ==k){
                        nomes[cont]=null;
                        pulo=0;
                    }
                }
                cont++;
            }
            sobrevivente = 0;
            for (int j =1;j<numLinhas+1;j++){ 
                if (nomes[j]!=null) {
                    sobrevivente++;
                    nome = nomes[j];
                }
            }
            sobrev = sobrevivente;
        }
        nK = Integer.toString(k);
        saida.write(k+" "+nome);
        saida.close(); 
        
        
            
            
        
    }
    
}
