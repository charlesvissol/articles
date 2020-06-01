package org.angrybee.test.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.setFirstname("Charles");
		student.setLastname("Vissol");
		
		ObjectMapper mapper = new ObjectMapper();	
	      try {
			mapper.writeValue(new File("student.json"), student);
			
			String value = mapper.writeValueAsString(student);
			System.out.println(value);
			
			String value2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			System.out.println(value2);
			
			
			Student student2 = mapper.readValue(value2, Student.class);
			
			System.out.println(student2.getFirstname() + " " + student2.getLastname());
			
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}

}
