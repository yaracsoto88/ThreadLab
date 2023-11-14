public class Controller {

    Model model;
    View view;


    public Controller() {
        this.model = new Model();
        this.view = new View(this);
    }
    public void play(int productors, int sliderProductor,boolean producerRandom, int consumidors, int sliderConsumidor, boolean consumerRandom){

        this.model.counter.setCount(0);
        this.model.counter.setProducerStartTime(0);
        this.model.counter.setProducerEndTime(0);
        this.model.counter.setCustomerStartTime(0);
        this.model.counter.setCustomerEndTime(0);
        this.model.counter.setThreadConsumer(0);
        this.model.counter.setThreadProducer(0);

        this.model.play(productors, sliderProductor, producerRandom, consumidors, sliderConsumidor, consumerRandom);
    }

    public View getView() {
        return view;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        Thread thread = new Thread(controller.getView());
        thread.start();


    }
}
