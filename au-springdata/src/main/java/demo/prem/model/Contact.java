package demo.prem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name="CONTACT")
public class Contact { //extends AbstractPersistable<Long>
	

	private Long id;
	private String name;
	private String phone;
	private String email;
	
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="CONTACT_NAME", nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="CONTACT_PHONE", nullable=false)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="CONTACT_EMAIL", nullable=false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=").append(id).append(", name=").append(name).append(", phone=").append(phone)
				.append(", email=").append(email).append("]");
		return builder.toString();
	}
	
}
