package mx.iteso.singleton;

/**
 * Created by mavg_ on 10/29/2015.
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    static private ChocolateBoiler instance;

    public static ChocolateBoiler getInstance(){
        if(null == instance){
            synchronized(ChocolateBoiler.class){
                if(null == instance){
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;

        }
    }
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }
    public boolean isEmpty() {
        return empty;
    }
    public boolean isBoiled() {
        return boiled;
    }
}