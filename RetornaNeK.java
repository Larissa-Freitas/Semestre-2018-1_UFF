/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad2programação;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author sobre
 */
public class RetornaNeK {
    int cont=0;
    int k = 0,n = 0;

    public RetornaNeK(int pN, int pK) throws FileNotFoundException, IOException {
        int posN=pN;
        int posK=pK; 
        
        
        
        InputStream arq = new FileInputStream("Arquivo.txt");
        InputStreamReader arqu = new InputStreamReader(arq);
        BufferedReader arquivo = new BufferedReader(arqu);
            
        String ler = arquivo.readLine();
                
        while (ler != null) {
            cont++;
            if (cont ==posN){
                n = Integer.parseInt(ler);
            }else {
                if (cont==posK){
                    k = Integer.parseInt(ler);
                }
            }
            ler = arquivo.readLine();
        }
        arquivo.close();
        
    }
    public int retornarN(){
        return n;
    }
    public int retornarK(){
        return k;
    }
    
    
}
