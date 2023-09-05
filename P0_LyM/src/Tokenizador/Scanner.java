package Tokenizador;

import java.util.ArrayList;
import java.util.List;
import Tokenizador.Reader;
import Tokenizador.Token;

public class Scanner {
    boolean fallaGramatical = false;    
    String valor =null;
    String tipo = null;
    Reader reader = new Reader();
    String[] funciones = {"jump","walk","leap","turn","turnto","drop","get","grab","letGo","nop"};
    String[] condicionales = {"if","else","while","repeat"};
    String[] operadores = {"facing","can","not"};
    String[] asignacion = {"="};
    String[] parentesis = {"(",")","{","}"};
    String[] direccion = {"north","south","east","west"};
    String[] direcciones = {"LEFT","RIGHT","UP","DOWN"};
    List<String> tokens = new ArrayList<>(); // Atributo para almacenar los tokens del archivo
    

    public Scanner() {
        List<String> tokens; // Atributo para almacenar los tokens del archivo
    }
        /**
         * Esta parte del codigo se encarga de decirle que tipo de token es y asi evaluarlo
         */
        public boolean esVariable(String tokenP) {    
                boolean loes = false;
                if(tokenP == "defVar"| tokenP == "defProc" ){
                    loes = true;
                }
                return loes;       
         }
        
    
        public boolean esFuncion(String tokenP) {
            boolean loes = false;
            for(int i=0;i< funciones.length; i++){
                if(tokenP == funciones[i]){
                    loes = true;
                }
            }
            return loes;
        }
    
        public boolean esCondicional(String tokenP) {
            boolean loes = false;
            for(int i=0;i< condicionales.length; i++){
                if(tokenP == condicionales[i]){
                    loes = true;
                }
            }
            return loes;
        }

    public boolean esOperador(String tokenP) {
        boolean loes = false;
        for(int i=0;i< operadores.length; i++){
            if(tokenP == operadores[i]){
                loes = true;
            }
        }
        return loes;
    }
    /**
     * Este es la parte de mi codigo que se encarga de verificar si la sintaxis y la sintactica es correcta
     * usando expresion regulares y lo que me venga por parametro puedo comparlo y asi decir si es correcta
     * o no el codigo.
     */
    public boolean esCorrectaVariable(String tokenP, String nextToken1, List<String> nextToken2) {
        boolean esCorrecta=false;
        if(tokenP == "defVar"){
            for(int i=0;i< nextToken1.length(); i++){
                String idExpRegular= "[a-zA-Z0-9]";
                String valueExpRegular= "[0-9]";
                if(nextToken1.matches(idExpRegular)){
                    esCorrecta=true;
                }
                if(nextToken2.get(0).matches(valueExpRegular)){
                    esCorrecta=true;
                }
            }
        }if(tokenP == "defProc"){  
            for(int i=0;i< funciones.length; i++){
                String parametrosExpresionRegular1 = "[A-Za-z]?";
                if(nextToken1 == funciones[i]){
                    esCorrecta=true;
                }if(nextToken2.get(0).matches("(")){
                    esCorrecta=true;
                }if(nextToken2.get(1).matches(parametrosExpresionRegular1)){
                    esCorrecta=true;
                }if(nextToken2.get(2).matches(",?")){
                    esCorrecta=true;
                }if(nextToken2.get(3).matches(parametrosExpresionRegular1)){
                    esCorrecta=true;
                }if(nextToken2.get(4).matches(")")){
                    esCorrecta=true;
                }
            }
        }
    return esCorrecta;
    } 

    public boolean esCorrectaFuncion(String tokenP, List<String> nextToken1) {
            boolean esCorrecta=false;
            if(tokenP == "jump" )
            {
                 if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;
                 }if(nextToken1.get(1).matches("[0-9]")){
                    esCorrecta=true;
                }if(nextToken1.get(2).matches(",")){
                    esCorrecta=true;
                }if(nextToken1.get(3).matches("[0-9]")){
                    esCorrecta=true;
                }if(nextToken1.get(4).matches(")")){ 
                    esCorrecta=true;
            }
        }
          else if(tokenP == "walk" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")) {
                    esCorrecta=true; 
                }if(nextToken1.get(2).matches(",?") | nextToken1.get(2).matches(")")){                
                    esCorrecta=true;

                }for(int i=0; i< direccion.length; i++){
                    if(nextToken1.get(3).equals(direccion[i])){
                        esCorrecta=true;
                    }
                }for(int i=0; i< direcciones.length; i++){
                    if(nextToken1.get(3).equals(direcciones[i])){
                        esCorrecta=true;
                    }
                }if(nextToken1.get(4).matches(")")){ 
                    esCorrecta=true;
                }
                

                
        }   
            else if(tokenP == "leap" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")) {
                    esCorrecta=true; 
                }if(nextToken1.get(2).matches(",?") | nextToken1.get(2).matches(")")){                
                    esCorrecta=true;

                }for(int i=0; i< direccion.length; i++){
                    if(nextToken1.get(3).equals(direccion[i])){
                        esCorrecta=true;
                    }
                }for(int i=0; i< direcciones.length; i++){
                    if(nextToken1.get(3).equals(direcciones[i])){
                        esCorrecta=true;
                    }
                }if(nextToken1.get(4).matches(")")){ 
                    esCorrecta=true;
                }
            }
            
            else if(tokenP == "turn" )
            {
              if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }
                for(int i=0; i< direcciones.length; i++){
                    if(nextToken1.get(1).equals(direcciones[i])){
                        esCorrecta=true;
                    }

                }if(nextToken1.get(2).matches(")")){ 
                    esCorrecta=true;
                }
            }
            else if(tokenP == "turnto" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }
                for(int i=0; i< direccion.length; i++){
                    if(nextToken1.get(1).equals(direccion[i])){
                        esCorrecta=true;
                    }

                }if(nextToken1.get(2).matches(")")){ 
                    esCorrecta=true;
                }
            }
            else if(tokenP == "drop" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")){
                    esCorrecta=true;    
                 }
                if(nextToken1.get(2).matches(")")){ 
                    esCorrecta=true;
                }
            }
            else if(tokenP == "get" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")){
                    esCorrecta=true;    

                }
                if(nextToken1.get(2).matches(")")){ 
                    esCorrecta=true;
                }
            }
            else if(tokenP == "grab" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")){
                    esCorrecta=true;    

                }
            }
            else if(tokenP == "letGo"){
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches("[0-9]")){
                    esCorrecta=true;    

                }
                if(nextToken1.get(2).matches(")")){ 
                    esCorrecta=true;
                }
            }
            else if(tokenP == "nop" )
            {
                if(nextToken1.get(0).matches("(")){
                    esCorrecta=true;    
                }if(nextToken1.get(1).matches(")")){
                    esCorrecta=true;    

                }
            }
            return esCorrecta;
    }
   


    public boolean esCorrectaCondicion(String tokenP, List<String> nextToken1, List<String> funcion, List<String> nextToken2) {
        boolean esCorrecta=false;
        for(int i=0;i< condicionales.length; i++){
            if(tokenP == condicionales[i]){
                esCorrecta=true;
            }
        }
        for(int i=0;i< operadores.length; i++){
            if(nextToken1.get(0) == operadores[i]){
                esCorrecta=true;
            }
        }
        if(nextToken1.get(1).matches("()")){
            esCorrecta=true;
        }
        if(esFuncion(funcion.get(0))==true){
            if(esCorrectaFuncion(funcion.get(0), funcion.subList(1, 5))){
                if(nextToken2.get(0).matches("{")){
                     if(esFuncion(nextToken2.get(0))==true){
                        if(esCorrectaFuncion(nextToken2.get(0), nextToken2.subList(1, 5))){
                            if(nextToken2.get(6).matches("}")){
                                esCorrecta=true;
                            }
                        }
                            
                  }
            }
        }
    }

        return esCorrecta;
    }

    /**
     * Esta parte del codigo se encarga de traer el texto de reader.java en token y comparlo con los tokens que tenemos en el enum
     * que tambien fueron almacenados en arrays de strings para asi verificar tanto su sintaxis como su sintactica
     */
    /**
     * En este lector de codigo lo que se hace es evaluar token por token y compararlo con los tokens que tenemos en el enum
     * de esa forma si resulta que corresponde tanto su sintaxis como su sintactica a traves del manejo de sublistas 
     * logramos verificar que el codigo este bien escrito y tambien para evitar que verifique tokens sin sentido movemos la cantidad
     * de posiciones que deberia ocupar tal sintaxis para asi que el siguiente token que evalue tenga que corresponder con algunos de los tokens
     * definidos anteriormente
     */
    public boolean lectorTexto(){
        tokens = reader.getTokens();
        for(int i=0;i< tokens.size(); i++){
            String tokenP = tokens.get(i);
            if(esVariable(tokenP)==true){
                String nextToken1 = tokens.get(i+1);
                List<String> nextToken2 = tokens.subList(i+2, i+7);
                if(esCorrectaVariable(tokenP,nextToken1,nextToken2)==false){
                    fallaGramatical = true;
                }else if(tokens.get(i+8) != null){
                    tokenP = tokens.get(i+8);
                }
            }
            if(esFuncion(tokenP)==true){
                List<String> nextToken1 = tokens.subList(i+1, i+5);
                if(esCorrectaFuncion(tokenP,nextToken1)==false){
                    fallaGramatical = true;
                }
             }else if(tokens.get(i+6) != null){
                tokenP = tokens.get(i+6);
             }
            if(esCondicional(tokenP)==true){
                List<String> nextToken1 = tokens.subList(i+1, i+2);
                List<String> funcion = tokens.subList(i+3, i+8);
                List<String> nextToken2 = tokens.subList(i+9, i+15);
                if(esCorrectaCondicion(tokenP,nextToken1,funcion,nextToken2)==false){
                    fallaGramatical = true;
                }else if(tokens.get(i+16) != null){
                    tokenP= tokens.get(i+16);
                }
            }
         }
      return fallaGramatical;      
     }


    public String getFallaGramatical(){
        if(fallaGramatical=true){
            return "El archivo tiene fallas gramaticales";
        }
        else{
            return "El archivo no tiene fallas gramaticales";
        }
    
    }
}