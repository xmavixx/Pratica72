
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String caminho;
        
        System.out.println("Digite o caminho completo do arquivo: ");
        caminho = scanner.next();
        
        ContadorPalavras contador = new ContadorPalavras(caminho);
        
        HashMap contaPalavras = contador.getPalavras(); 
        Object[] palavras = contaPalavras.keySet().toArray();
        
        int num = contaPalavras.size();
        
        int[] numeroDeVezes = new int[num];
        String[] palavraRepetida = new String[num];
        
        for(int i = 0; i < palavras.length; i++) {
            palavraRepetida[i] = (String) palavras[i];
            numeroDeVezes[i] = (int) contaPalavras.get(palavraRepetida[i]);
        }
        
        int aux;
        String auxi;
        
        for(int i = 0; i < palavraRepetida.length; i++) {
            for(int j = i+1; j < palavraRepetida.length; j++) {
                if(numeroDeVezes[i] > numeroDeVezes[j]) {
                    aux = numeroDeVezes[i];
                    auxi = palavraRepetida[i];
                    numeroDeVezes[i] = numeroDeVezes[j];
                    palavraRepetida[i] = palavraRepetida[j];
                    numeroDeVezes[j] = aux;
                    palavraRepetida[j] = auxi;
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminho + ".out"));
         for(int i = 0; i < palavraRepetida.length; i++){
             bw.write(palavraRepetida[i] + "," + numeroDeVezes[i]);
             bw.newLine();
         }

         bw.close();
        
    }
}
