package DTO;

public class LabResults {
    public int contador;
    public long ProducerStartTime;
    public long ProducerEndTime;
    public long CustomerStartTime;
    public long CustomerEndTime;
    public long threadTime;
    public float AvgThreadCreacion;
    public long startTime;
    public float avgStart;
    public int itemsConsumidos;
    public int itemsProducidos;
    public int hilosProcesandoProductor;
    public int hilosFinalizadosProductor;
    public int hilosProcesandoConsumidor;
    public int hilosFinalizadosConsumidor;
    // pendientes: todos los totales- hilos finalizados

    public LabResults() {

    }

    public LabResults(int contador, long ProducerStartTime, long ProducerEndTime, long CustomerStartTime,
            long CustomerEndTime, long threadTime, float AvgThreadCreacion, long startTime, float avgStart,
            int itemsConsumidos, int itemsProducidos) {
        this.contador = contador;
        this.ProducerStartTime = ProducerStartTime;
        this.ProducerEndTime = ProducerEndTime;
        this.CustomerStartTime = CustomerStartTime;
        this.CustomerEndTime = CustomerEndTime;
        this.threadTime = threadTime;
        this.AvgThreadCreacion = AvgThreadCreacion;
        this.startTime = startTime;
        this.avgStart = avgStart;
        this.itemsConsumidos = itemsConsumidos;
        this.itemsProducidos = itemsProducidos;
    }

}
