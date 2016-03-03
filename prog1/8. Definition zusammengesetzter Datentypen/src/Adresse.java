
public class Adresse {

	public String firstname;
	public String lastname;
	public String street;
	public int street_number;
	public char street_number_addition;
	public int zipcode;
	public String city;
	public String country;
	
	public Adresse(String firstname, String lastname, String street, int street_number, char street_number_addition, int zipcode, String city, String country) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.street_number = street_number;
		this.street_number_addition = street_number_addition;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
		
	};

	public Adresse(String firstname, String lastname, String street, int street_number, int zipcode, String city, String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.street_number = street_number;
		this.street_number_addition = '\0';
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	};

	public String toString() {
		return this.firstname + " " + this.lastname + "\n"
	+ this.street + " " + this.street_number + this.street_number_addition + "\n"
	+ this.zipcode + " " + this.city + "\n"
	+ this.country;
	}
	
	public boolean equals(Adresse adr) {
		return this.firstname.equals(adr.firstname) && this.lastname.equals(adr.lastname) && this.street.equals(adr.street)
				&& this.street_number == adr.street_number && this.street_number_addition == adr.street_number_addition
				&& this.zipcode == adr.zipcode && this.city.equals(adr.city) && this.country.equals(adr.country); 
	}
	
	public Adresse clone() {
		return new Adresse(this.firstname, this.lastname, this.street, this.street_number, this.street_number_addition,
				this.zipcode, this.city, this.country);
	}
	
}
