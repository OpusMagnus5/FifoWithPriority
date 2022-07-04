import java.util.ArrayList;

public class FIFO {
    private ArrayList<Element> queue = new ArrayList<>();
    private int highestPriority = 0;

    private static final FIFO fifo = new FIFO();

    private FIFO(){

    }

    public static FIFO getInstance(){
        return fifo;
    }

    public void add(String value, int priority){
        this.queue.add(new Element(value, priority));
        if (priority > this.highestPriority) {
            this.highestPriority = priority;
        }
    }

    public void addWithHighestPriority(String value){
        this.add(value, this.highestPriority++);
    }

    public String get(){
        Element element;
        int count = 0;
        if (this.queue.size() > 0) {
            element = this.queue.get(this.queue.size() - 1);
            for (int i = this.queue.size() - 1; i >= 0; i--, ++count) {
                if (element.getPriority() < this.queue.get(i).getPriority()) {
                    element = this.queue.get(i);
                }
                if (count == 3) {
                    break;
                }
            }
        }else{
            return "Kolejka Pusta!";
        }
        this.queue.remove(element);
        return element.getMessage();
    }

    public String getHighestPriority(){
        Element element;
        if (this.queue.size() > 0) {
            element = this.queue.get(this.queue.size() - 1);
            for (int i = this.queue.size() - 1; i >= 0; i--) {
                if (element.getPriority() < this.queue.get(i).getPriority()) {
                    element = this.queue.get(i);
                }
            }
        }else {
            return "Kolejka pusta!";
        }
        this.queue.remove(element);
        return element.getMessage();
    }
}
