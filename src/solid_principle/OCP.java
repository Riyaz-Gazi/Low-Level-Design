package solid_principle;

interface TaxCalculator{
    double amountAfterTax(double amount);
}

class IndianTax implements TaxCalculator{

    @Override
    public double amountAfterTax(double amount) {
        return (amount-0.18*amount);
    }
}

class USTax implements TaxCalculator{

    @Override
    public double amountAfterTax(double amount) {
        return (amount-0.1*amount);
    }
}

class InvoiceService{

    private double amount;
    private TaxCalculator taxCalculator;

    public InvoiceService(double amount, TaxCalculator taxCalculator) {
        this.amount = amount;
        this.taxCalculator = taxCalculator;
    }

    public double getTotalAmount(){
        return taxCalculator.amountAfterTax(amount);
    }
}

public class OCP {
    public static void main(String[] args) {
        InvoiceService invoiceServiceIndian = new InvoiceService(1000,new IndianTax());
        System.out.println("Total amount after tax in India : " + invoiceServiceIndian.getTotalAmount());

        InvoiceService invoiceServiceUS = new InvoiceService(1000,new USTax());
        System.out.println("Total amount after tax in US : " + invoiceServiceUS.getTotalAmount());

    }
}


// OCP Violation
class InvoiceProcessor {
    public double calculateTotal(String region, double amount) {
        if (region.equalsIgnoreCase("India")) {
            return amount + amount * 0.18;
        } else if (region.equalsIgnoreCase("US")) {
            return amount + amount * 0.08;
        } else if (region.equalsIgnoreCase("UK")) {
            return amount + amount * 0.12;
        } else {
            return amount; // No tax for unknown region
        }
    }
}

