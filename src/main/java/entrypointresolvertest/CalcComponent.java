package entrypointresolvertest;

public class CalcComponent 
{	
	public Long add(Integer number1, Integer number2)
	{
		return (long)(number1 + number2);
	}
	
	public Integer sub(Integer number1, Integer number2)
	{
		return (number1 - number2);
	}
	
	public Long mul(Integer number1, Integer number2)
	{
		return (long)(number1 * number2);
	}
	
	public Integer div(Integer number1, Integer number2)
	{
		return number1 / number2;
	}
}
