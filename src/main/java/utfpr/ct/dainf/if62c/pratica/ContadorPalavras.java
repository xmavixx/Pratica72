/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author askoda
 */
public class ContadorPalavras {
    private String lugar;
    private BufferedReader reader; 
 
    public ContadorPalavras(String lugar) {
        this.lugar = lugar;
        
        try {
            reader = new BufferedReader(new FileReader(lugar));
        }catch(FileNotFoundException e) {
        }
    }
    
    public HashMap getPalavras() throws IOException {
        int numPalavras = 0;
        HashMap<String, Integer> contador = new HashMap();
        boolean fim = true, achou = false;
        String palavra;
        numPalavras = 0;
        
        String line = reader.readLine();
        
        while(line != null) {
            StringTokenizer t = new StringTokenizer(line," \n\r\t");
            
            while(t.hasMoreTokens()) {
                String s1 = t.nextToken().toLowerCase();
                
                if(contador.containsKey(s1)) {
                    int num = contador.get(s1) + 1;
                    contador.put(s1, num);
                }
                else {
                    contador.put(s1, 1);
                }
            }
            line = reader.readLine();
        }
        
        reader.close();
        
        return contador;
    }
    
}
