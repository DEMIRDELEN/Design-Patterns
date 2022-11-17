package CreationalDP.SingletonDP;

public class SingletonObject {

    String message = "Merhaba";

    private static SingletonObject instance = new SingletonObject();

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void showMessage() {
        this.message = this.message + " batch 82-83";
        System.out.println(this.message);
    }
}
