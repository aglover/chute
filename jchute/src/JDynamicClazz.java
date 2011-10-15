/**
 * Created by IntelliJ IDEA.
 * User: aglover
 * Date: 10/11/11
 * Time: 1:37 PM
 */
public class JDynamicClazz {

    private String message;

    public JDynamicClazz(String msg) {
        this.message = msg;
    }

    public void run() {
       System.out.println("running my JDynamicClazz with message " + message);
    }
}
