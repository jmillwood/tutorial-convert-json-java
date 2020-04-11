package com.johnrmillwood.tutorial;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ContactManagerTest {

	@Test
	public void testConvertJsonFileToObject() {
		try {
			String filePath = "src/test/resources/contact-1.json";
			Contact contact = new ContactManager().convertJsonFileToObject(filePath);
			Assert.assertNotNull(contact);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertObjectToJsonFile() {
		try {
			String filePath = "src/test/resources/contact-2.json";
			Contact contact = new Contact("Jane", "Doe", "janedoe@somewhere.com");
			new ContactManager().convertObjectToJsonFile(contact, filePath);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertJsonFileToObjectList() {
		try {
			String filePath = "src/test/resources/contacts-1.json";
			List<Contact> contacts = new ContactManager().convertJsonFileToObjectList(filePath);
			Assert.assertEquals(2, contacts.size());
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertObjectListToJsonFile() {
		try {
			String filePath = "src/test/resources/contacts-2.json";
			List<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John", "Doe", "johndoe@somewhere.com"));
			contacts.add(new Contact("Jane", "Doe", "janedoe@somewhere.com"));
			new ContactManager().convertObjectListToJsonFile(contacts, filePath);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertJsonStringToObject() {
		try {
			String json = "{\"firstName\": \"John\", \"lastName\": \"Doe\"}";
			Contact contact = new ContactManager().convertJsonStringToObject(json);
			Assert.assertNotNull(contact);
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertObjectToJsonString() {
		try {
			String expected = "{\"emailAddress\":\"janedoe@somewhere.com\",\"firstName\":\"Jane\",\"lastName\":\"Doe\"}";
			Contact contact = new Contact("Jane", "Doe", "janedoe@somewhere.com");
			String actual = new ContactManager().convertObjectToJsonString(contact);
			Assert.assertTrue(expected.equals(actual));
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertJsonStringToObjectList() {
		try {
			String json = "[{\"firstName\": \"John\", \"lastName\": \"Doe\"}, {\"firstName\" :\"Jane\", \"lastName\": \"Doe\"}]";
			List<Contact> contacts = new ContactManager().convertJsonStringToObjectList(json);
			Assert.assertEquals(2, contacts.size());
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
	
	@Test
	public void testConvertObjectListToJsonString() {
		try {
			String expected = "[{\"emailAddress\":\"johndoe@somewhere.com\",\"firstName\":\"John\",\"lastName\":\"Doe\"},{\"emailAddress\":\"janedoe@somewhere.com\",\"firstName\":\"Jane\",\"lastName\":\"Doe\"}]";
			List<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John", "Doe", "johndoe@somewhere.com"));
			contacts.add(new Contact("Jane", "Doe", "janedoe@somewhere.com"));
			String actual = new ContactManager().convertObjectListToJsonString(contacts);
			Assert.assertTrue(expected.equals(actual));
		} catch (Exception e) {
			Assert.fail(e.toString());
		}
	}
}