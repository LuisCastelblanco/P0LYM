package Tokenizador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class Reader {
    private List<String> tokens; // Atributo para almacenar los tokens
    private Tokenizador.Scanner Scanner;

    public Reader() {
        tokens = new ArrayList<>(); // Inicializa la lista de tokens vacía
    }
    //TOKENIZADOR
    //TRAE TODA LA INFORMACION DEL ARRAY EN TOKENS SEPARADOS
    public List<String> tokenizeFileToList(String filePath) {
        
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
    /**
	 * Este metodo imprime un mensaje enviado como argumento
	 * y recibe una respuesta por el usuario
	 * @param mensaje
	 * @return Cadena de caracteres que el ususario ingresa
	 * @throws IOException
	 */
	public String input(String mensaje) throws IOException
	{
		System.out.print(mensaje + ": ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}

    public List<String> getTokens() {
        return tokens; // Método para obtener la lista de tokens
    }
    public void printResultado() throws IOException{

        String filePath = input("Ingresa el archivo de texto"); // Reemplaza con la ruta correcta
        tokens= tokenizeFileToList(filePath);
        boolean aDevolver = Scanner.lectorTexto(tokens);
        if(aDevolver == true){
            System.out.println("El texto es valido");
        }else{  
            System.out.println("El texto no es valido");
        }
        
    }
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        reader.printResultado();
    }
    //FIN
}