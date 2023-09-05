package Tokenizador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Reader {
    private List<String> tokens; // Atributo para almacenar los tokens
    private Tokenizador.Scanner Scanner;

    public Reader() {
        tokens = new ArrayList<>(); // Inicializa la lista de tokens vacía
    }

    public List<String> tokenizeFileToList(String filePath) {
        filePath = "ruta/al/archivo.txt"; // Reemplaza con la ruta correcta
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Utiliza StringTokenizer para dividir cada línea en tokens
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    tokens.add(token);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tokens;
    }

    public List<String> getTokens() {
        return tokens; // Método para obtener la lista de tokens
    }
    public void printResultado(){
        String aDevolver = Scanner.getFallaGramatical();
        System.out.println(aDevolver);
    }
}