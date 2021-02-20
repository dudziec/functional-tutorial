import java.util.ArrayList;
import java.util.List;

public class Customer {
    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Customer() {}

    public static List<String> getEnabledCustomerNames() {
        return Customer.getEnabledCustomerField(customer -> customer.name);
    }
    public static List<String> getEnabledCustomerStates() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            @Override
            public String call(Customer customer) {
                return customer.state;
            }
        });
    }

    public static List<String> getEnabledCustomerDomains() {
        return Customer.getEnabledCustomerField(customer -> customer.domain);
    }

    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func) {
        ArrayList<B> outList = new ArrayList<>();
        for (Customer customer : allCustomers) {
            if(Boolean.TRUE.equals(customer.enabled)) outList.add(func.call(customer));
        }
        return outList;
    }

    private static class CustomerDomains implements Function1<Customer, String> {
        @Override
        public String call(Customer customer) { return customer.domain; }
    }

    private static class CustomerStates implements Function1<Customer, String> {
        @Override
        public String call(Customer customer) { return customer.address; }
    }

    private static class CustomerAsCustomer implements  Function1<Customer, Customer> {

        @Override
        public Customer call(Customer customer) {
            return customer;
        }
    }

    /* TODO: Dodanie funkcji main */
    public static void main(String[] args) {

    }
}