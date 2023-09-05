package Tokenizador;

public class Token 
{
	private final String valor;
	private final Tokens tipo;
	
	
	public Token (String valor, Tokens tipo) 
	{
	
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public String getValor() 
	{
		return valor;
	}
	
	public Tokens getTipo()
	{
		return tipo;
	}

}

