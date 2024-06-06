package com.example.ItemWriter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class FirstItemWriter implements ItemWriter<Long> {

	@Override
	public void write(List<? extends Long> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am in First Item Writer");
		
		items.stream().forEach(System.out::println);
	}

}
