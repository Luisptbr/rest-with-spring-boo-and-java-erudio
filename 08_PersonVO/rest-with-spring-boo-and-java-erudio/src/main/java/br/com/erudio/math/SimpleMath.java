package br.com.erudio.math;


public class SimpleMath {
		
		//SOMA
		public Double sum(Double numberOne, Double numberTwo) 
		{				
			return  numberOne + numberTwo;
		}
		
		//DIVISÃO		
		public Double div(Double numberOne, Double numberTwo)
		{
			return  numberOne / numberTwo;
		}
		
		//SUBTRAÇÃO
		public Double sub(Double numberOne, Double numberTwo)
		{
			return  numberOne - numberTwo;
		}
		
		//MULTIPLICAÇÃO
		public Double mult(Double numberOne, Double numberTwo)
		{
			return  numberOne * numberTwo;
		}
		
		//MEDIA		
		public Double med(Double numberOne, Double numberTwo)
		{
			return (numberOne + numberTwo) / 2;
		}
		
		//RAIZ QUADRADA		
		public Double raiz(Double number)
		{
			return Math.sqrt(number);
		}
}
