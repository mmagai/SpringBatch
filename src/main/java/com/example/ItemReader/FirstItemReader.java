package com.example.ItemReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;


@Component
public class FirstItemReader implements ItemReader<Integer> {

	List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
	int i = 0;
	
	
	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		System.out.println("I am in First Item Reader");
		Integer item;
		
		if(i < integerList.size()){
			
			item = integerList.get(i++);
			return item;
			
		}
		
		return null;
	}

}
