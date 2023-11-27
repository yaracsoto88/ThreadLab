package DTO;

public class LabParameters {
    public int consumidores;
    public int productores;
    public boolean timeConsumeRandom;
    public boolean timeProduceRandom;
    public int sliderConsumer;
    public int sliderProducer;
    public boolean preventNegativeStocks;
    public boolean protectCriticalRegions;
    public int itemConsumidor;
    public int itemProductor;


    public LabParameters() {
    }

    public LabParameters(int consumidores, int productores, boolean timeConsumeRandom, boolean timeProduceRandom, int sliderConsumer, int sliderProducer, boolean preventNegativeStocks, boolean protectCriticalRegions) {
        this.consumidores = consumidores;
        this.productores = productores;
        this.timeConsumeRandom = timeConsumeRandom;
        this.timeProduceRandom = timeProduceRandom;
        this.sliderConsumer = sliderConsumer;
        this.sliderProducer = sliderProducer;
        this.preventNegativeStocks = preventNegativeStocks;
        this.protectCriticalRegions = protectCriticalRegions;
    }

    public LabParameters(int consumidores, int productores, boolean timeConsumeRandom, boolean timeProduceRandom, int sliderConsumer, int sliderProducer, boolean preventNegativeStocks, boolean protectCriticalRegions, int itemConsumidor, int itemProductor) {
        this.consumidores = consumidores;
        this.productores = productores;
        this.timeConsumeRandom = timeConsumeRandom;
        this.timeProduceRandom = timeProduceRandom;
        this.sliderConsumer = sliderConsumer;
        this.sliderProducer = sliderProducer;
        this.preventNegativeStocks = preventNegativeStocks;
        this.protectCriticalRegions = protectCriticalRegions;
        this.itemConsumidor = itemConsumidor;
        this.itemProductor = itemProductor;
    }



}
