// 1. Spring ServiceLocatorFactoryBean Example

// Define a common interface
public interface PaymentService {
    void pay(double amount);
}

// Two concrete implementations
@Component("creditCardService")
public class CreditCardService implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid with Credit Card: " + amount);
    }
}

@Component("paypalService")
public class PaypalService implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid with PayPal: " + amount);
    }
}

// Service locator interface
public interface PaymentServiceFactory {
    PaymentService getPaymentService(String serviceName);
}

// Config for ServiceLocatorFactoryBean
@Configuration
public class ServiceLocatorConfig {
    @Bean
    public ServiceLocatorFactoryBean paymentServiceFactory() {
        ServiceLocatorFactoryBean factory = new ServiceLocatorFactoryBean();
        factory.setServiceLocatorInterface(PaymentServiceFactory.class);
        return factory;
    }
}

// Usage
@Service
public class BillingService {
    @Autowired
    private PaymentServiceFactory paymentFactory;

    public void processPayment(String type, double amount) {
        PaymentService service = paymentFactory.getPaymentService(type);
        service.pay(amount);
    }
}


// 2. Custom HashMap-based Service Locator Implementation

public class SimpleServiceLocator {
    private static final Map<String, PaymentService> registry = new HashMap<>();

    static {
        registry.put("creditCard", new CreditCardService());
        registry.put("paypal", new PaypalService());
    }

    public static PaymentService getService(String name) {
        return registry.get(name);
    }

    public static void register(String name, PaymentService service) {
        registry.put(name, service);
    }
}

// Usage
public class AppManualLocator {
    public static void main(String[] args) {
        PaymentService service = SimpleServiceLocator.getService("paypal");
        service.pay(1000.0);
    }
}
