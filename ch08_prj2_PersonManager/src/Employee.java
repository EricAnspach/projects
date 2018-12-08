public class Employee extends Person {
	
	String ssn;

	public Employee(String first, String last, String ssnString) {
		super(first, last);
		ssn = ssnString;
	}

	public String getSsn() {
		String maskedSSN = "xxx-xx-";
		maskedSSN += ssn.substring(5,9);		
		return maskedSSN;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nSSN: " + getSsn();
	}

	

	
}
