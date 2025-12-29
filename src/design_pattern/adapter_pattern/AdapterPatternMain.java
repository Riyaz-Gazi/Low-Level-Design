package design_pattern.adapter_pattern;

interface PaymentGateway{
    void pay(String orderId,double amount);
}

class PayUGateway implements PaymentGateway{

    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid "+amount+" using PayU for order : "+orderId);
    }
}

class RazorpayAPI{
    public void makePayment(String invoiceId, double amount){
        System.out.println("Paid "+amount+" using Razorpay for invoice: "+invoiceId);
    }
}

class RazorpayAdapter implements PaymentGateway{

    private RazorpayAPI razorpayAPI;

    public RazorpayAdapter(){
        this.razorpayAPI = new RazorpayAPI();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorpayAPI.makePayment(orderId,amount);
    }
}

class CheckoutService{
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId,double amount){
        paymentGateway.pay(orderId,amount);
    }
}

public class AdapterPatternMain {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new RazorpayAdapter());
        checkoutService.checkout("1",120.0);
    }
}
