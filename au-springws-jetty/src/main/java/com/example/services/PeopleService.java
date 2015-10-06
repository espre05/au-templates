package com.example.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.example.exceptions.PersonAlreadyExistsException;
import com.example.exceptions.PersonNotFoundException;
import com.example.model.Person;

@Service
public class PeopleService {
	private final ConcurrentMap< String, Person > persons = new ConcurrentHashMap< String, Person >();
	
	public PeopleService(){
		initMock();
	}
	
	public List< Person > getPeople( int page, int pageSize ) {
		final List< Person > peopleSlice = new ArrayList< Person >( pageSize );
		
        final Iterator< Person > iterator = persons.values().iterator();
        for( int i = 0; peopleSlice.size() < pageSize && iterator.hasNext(); ) {
        	if( ++i > ( ( page - 1 ) * pageSize ) ) {
        		peopleSlice.add( iterator.next() );
        	}
        }
		
		return peopleSlice;
	}
	
	private void initMock() {
		for (int i = 0; i < 10; i++) {
			Person pers =  new Person("Jane"+(i+1),"Doe");
			pers.setEmail("email"+(i+1));
			persons.putIfAbsent(pers.getEmail(), pers);
		}
		
	}

	public Person getByEmail( final String email ) {
		final Person person = persons.get( email );
		
		if( person == null ) {
			throw new PersonNotFoundException( email );
		}
		
		return person;
	}

	public Person addPerson( final String email, final String firstName, final String lastName ) {
		final Person person = new Person( email );
		person.setFirstName( firstName );
		person.setLastName( lastName );
				
		if( persons.putIfAbsent( email, person ) != null ) {
			throw new PersonAlreadyExistsException( email );
		}
		
		return person;
	}
	
	public void removePerson( final String email ) {
		if( persons.remove( email ) == null ) {
			throw new PersonNotFoundException( email );
		}
	}
}
