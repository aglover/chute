/**
 * Created by IntelliJ IDEA.
 * User: aglover
 * Date: 10/11/11
 * Time: 1:37 PM
 */
public class DynamicClazz implements Runnable {

    private String message;

    public DynamicClazz(String msg) {
        this.message = msg;
    }

    public void run() {

        System.out.println("running my job with message " + message);

        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
    }
}
