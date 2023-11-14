public class Counter {
    private int count;

    private long ProducerStartTime;
    private long ProducerEndTime;
    private  long CustomerStartTime;
    private long CustomerEndTime;
    private long threadTime;
    private long AvgThreadCreacion;


    public Counter() {
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public long getProducerEndTime() {
        return ProducerEndTime;
    }

    public synchronized void updateProducersTimes(long producerEndTime, long producerStartTime) {
        if (this.ProducerEndTime < producerEndTime){
            this.ProducerEndTime = producerEndTime;
            this.ProducerStartTime = producerStartTime;
        }
    }

    public void setProducerEndTime(long producerEndTime) {
        ProducerEndTime = producerEndTime;
    }

    public void setCustomerEndTime(long customerEndTime) {
        CustomerEndTime = customerEndTime;
    }

    public long getCustomerEndTime() {
        return CustomerEndTime;
    }

    public synchronized void updateCustomersTimes(long customerEndTime, long customerStartTime) {
        if ( this.CustomerEndTime < customerEndTime){
            this.CustomerEndTime = customerEndTime;
            this.CustomerStartTime =customerStartTime;
        }
    }

    public long getProducerStartTime() {
        return ProducerStartTime;
    }

    public void setProducerStartTime(long producerStartTime) {
        ProducerStartTime = producerStartTime;
    }

    public long getCustomerStartTime() {
        return CustomerStartTime;
    }

    public void setCustomerStartTime(long customerStartTime) {
        CustomerStartTime = customerStartTime;
    }


    public long getThreadTime() {
        return this.threadTime;
    }

    public void setThreadTime(long threadTime) {
        this.threadTime = threadTime;
    }

    public long getAvgThreadCreacion() {
        return this.AvgThreadCreacion;
    }

    public void setAvgThreadCreacion(long AvgThreadCreacion) {
        this.AvgThreadCreacion = AvgThreadCreacion;
    }

}
