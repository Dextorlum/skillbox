import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {   String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String regexPhone = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

        String[] components = data.split("\\s+");
        if (!(components.length == 4)){
            throw new IllegalArgumentException("Wrong format");
        }
        if (!components[2].trim().matches(regexEmail)) {
            throw new IllegalArgumentException("Wrong format email");
        }
        if (!components[3].matches(regexPhone)) {
            throw new IllegalArgumentException("Wrong format phone number");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsValue(name)) {
            throw new IndexOutOfBoundsException("This user do not exist in storage");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}