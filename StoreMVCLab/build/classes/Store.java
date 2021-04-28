public class Store{
    private CashRegister cashRegister;
    private Product product;
    
    public Store(){
        cashRegister = new CashRegister();
        product = new Product("Sticky tape", 200, 2.99);
        // add the product observer
        product.addProductObserver(cashRegister);   
    }
    
    public final Product getProduct(){ return product; }
    
    public final CashRegister getCashRegister(){ return cashRegister; }
}