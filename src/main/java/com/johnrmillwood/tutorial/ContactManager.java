package com.johnrmillwood.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ContactManager {

	public Contact convertJsonFileToObject(String filePath) throws IOException {
		try (FileInputStream stream = new FileInputStream(new File(filePath))) {
			return new ObjectMapper().readValue(stream, Contact.class);
        }
	}
	
	public void convertObjectToJsonFile(Contact contact, String filePath) throws IOException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(filePath), contact);
	}
	
	public List<Contact> convertJsonFileToObjectList(String filePath) throws IOException {
		try (FileInputStream stream = new FileInputStream(new File(filePath))) {
			return new ObjectMapper().readValue(stream, new TypeReference<List<Contact>>() {});
        }
	}
	
	public void convertObjectListToJsonFile(List<Contact> contacts, String filePath) throws IOException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(filePath), contacts);
	}
	
	public Contact convertJsonStringToObject(String json) throws IOException {
		return new ObjectMapper().readValue(json, Contact.class);
	}
	
	public String convertObjectToJsonString(Contact contact) throws IOException {
		return new ObjectMapper().writeValueAsString(contact);
	}
	
	public List<Contact> convertJsonStringToObjectList(String json) throws IOException {
		return Arrays.asList(new ObjectMapper().readValue(json, Contact[].class));
	}
	
	public String convertObjectListToJsonString(List<Contact> contacts) throws IOException {
		return new ObjectMapper().writeValueAsString(contacts);
	}
}