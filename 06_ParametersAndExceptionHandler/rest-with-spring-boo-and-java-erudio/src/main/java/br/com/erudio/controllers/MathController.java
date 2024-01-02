package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;
import java.lang.Math;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	private  final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	//SOMA
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sum(
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if (!NumberConverter.isNumeric (numberOne) || !NumberConverter.isNumeric (numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.sum(NumberConverter.convertToDouble (numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	//DIVISÃO
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double div(
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if (!NumberConverter.isNumeric (numberOne) || !NumberConverter.isNumeric (numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.div(NumberConverter.convertToDouble (numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	//SUBTRAÇÃO
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double sub(
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if (!NumberConverter.isNumeric (numberOne) || !NumberConverter.isNumeric (numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.sub(NumberConverter.convertToDouble (numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	//MULTIPLICAÇÃO
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double mult(
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if (!NumberConverter.isNumeric (numberOne) || !NumberConverter.isNumeric (numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.mult(NumberConverter.convertToDouble (numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	//MEDIA
	@RequestMapping (value = "/med/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double med(
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if (!NumberConverter.isNumeric (numberOne) || !NumberConverter.isNumeric (numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.med(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	//RAIZ QUADRADA
	@RequestMapping(value = "/raiz/{number}", 
			method=RequestMethod.GET)
	public Double raiz( 
			 //@PathVariable é utilizada para recuperar dados da URL
			@PathVariable(value = "number") String number
			)throws Exception{
		
		if (!NumberConverter.isNumeric (number)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return math.raiz(NumberConverter.convertToDouble (number));
	}

	
	
}
