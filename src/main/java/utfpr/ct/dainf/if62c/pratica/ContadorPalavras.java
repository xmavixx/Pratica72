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
 
    public ContadorPalavras(String lugar) throws FileNotFoundException {
        this.lugar = lugar;
        reader = new BufferedReader(new FileReader(lugar));
    }
    
    public HashMap getPalavras() throws IOException {
        HashMap<String, Integer> contador = new HashMap();
        
        String line = reader.readLine();
        
        while(line != null) {
            StringTokenizer t = new StringTokenizer(line," \n\r\t");
            
            while(t.hasMoreTokens()) {
                String s1 = t.nextToken();
                
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
