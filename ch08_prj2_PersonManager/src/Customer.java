public class Customer extends Person {

    private String customerNumber;

    public Customer(String first, String last, String number) {
        super(first, last);
        customerNumber = number;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String number) {
        customerNumber = number;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Customer Number: " + customerNumber;
    }
}
