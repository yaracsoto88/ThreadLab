package Model;

public class Product extends ProtectedCounter {
    private String description;
    private int producedQuantity;
    private int consumedQuantity;

    public Product(String description, int producedQuantity, int consumedQuantity) {
        this.description = description;
        this.producedQuantity = 0;
        this.consumedQuantity = 0;
    }

    public void produce(boolean synchron) {
        if (synchron) {
            super.inc_syncro();
        } else {
            super.inc();
        }
        
    }

    public void consume(boolean synchron) {
        if (synchron) {
            super.dec_syncro();
        } else {
            super.dec();
        }
    }

    public int getStock() {
        return super.getValue();

    }

}
