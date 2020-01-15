package bean;

import java.io.Serializable;
import java.util.Arrays;

public class CustomerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name;
	public String gender;
	public String address;
	public String country;
	public String[] receive;
	public long customerId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getReceive() {
		return receive;
	}

	public void setReceive(String[] receive) {
		this.receive = receive;
	}

	public String getReceiveInString() {
		return Arrays.toString(receive);
	}
}
