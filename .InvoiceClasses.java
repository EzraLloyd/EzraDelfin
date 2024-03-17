import java.time.LocalDate;

public class Client {
    private int clientId;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Client() {}

    public Client(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and setters
}

public class Service {
    private int serviceId;
    private String name;
    private String description;
    private double rate;

    public Service() {}

    public Service(String name, String description, double rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    // Getters and setters
}

public class Invoice {
    private int invoiceId;
    private int clientId;
    private LocalDate invoiceDate;
    private double totalAmount;

    public Invoice() {}

    public Invoice(int clientId, LocalDate invoiceDate, double totalAmount) {
        this.clientId = clientId;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
}
