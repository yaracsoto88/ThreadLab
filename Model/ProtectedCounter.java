package Model;
public class ProtectedCounter {
    private int count;

    public ProtectedCounter() {
        this.count = 0;
    }

    public void inc() {
        this.count++;
    }

    public void dec() {
        this.count--;
    }
    public synchronized void inc_syncro(){

    }
    public synchronized void dec_syncro(){}


    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getValue(){
        return count;

    }


}
