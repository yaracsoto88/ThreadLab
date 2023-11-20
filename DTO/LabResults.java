package DTO;

public class LabResults {
    public long ProducerStartTime;
    public long ProducerEndTime;
    public long CustomerStartTime;
    public long CustomerEndTime;
    public long threadTime;
    public float AvgThreadCreacion;
    public long startTime;
    public float avgStart;

    public LabResults() {

    }

    public LabResults(long ProducerStartTime, long ProducerEndTime, long CustomerStartTime, long CustomerEndTime, long threadTime, float AvgThreadCreacion, long startTime, float avgStart) {
        this.ProducerStartTime = ProducerStartTime;
        this.ProducerEndTime = ProducerEndTime;
        this.CustomerStartTime = CustomerStartTime;
        this.CustomerEndTime = CustomerEndTime;
        this.threadTime = threadTime;
        this.AvgThreadCreacion = AvgThreadCreacion;
        this.startTime = startTime;
        this.avgStart = avgStart;
    }
    

}
