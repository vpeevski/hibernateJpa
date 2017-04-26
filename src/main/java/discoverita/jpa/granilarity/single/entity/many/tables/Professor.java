package discoverita.jpa.granilarity.single.entity.many.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
@SecondaryTable(name = "EMP_ADDRESS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID"))
public class Professor {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	@Column(table = "EMP_ADDRESS")
	private String street;

	@Column(table = "EMP_ADDRESS")
	private String city;

	@Column(table = "EMP_ADDRESS")
	private String state;

	@Column(name = "ZIP_CODE", table = "EMP_ADDRESS")
	private String zip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		return "Professor id: " + getId() + " name: " + getName();
	}
}
