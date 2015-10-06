package com.example;
import com.example.model.Person;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import java.util.ArrayList;
import java.util.List;

public class CxfClientApp 
{
    public static void main( String[] args )  throws Exception { 
      
     List<Object> providers = new ArrayList<Object>();
     providers.add( new JacksonJaxbJsonProvider() );
   
     WebClient client = WebClient.create("http://localhost:8080/rest//api/v1", providers);
     client = client.accept("application/json").type("application/json").path("/people/getbyemail").query("email1");
   
     Person person = client.get(Person.class);
     System.out.println("Person:" + person.getFirstName());
  
    }
}