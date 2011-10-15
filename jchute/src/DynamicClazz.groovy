
/**
 * Created by IntelliJ IDEA.
 * User: aglover
 * Date: 10/14/11
 * Time: 4:59 PM
 */
class DynamicClazz implements Runnable{

    private String message;

    public DynamicClazz(String msg) {
        this.message = msg;
    }

    public void run() {

        System.out.println("running my job with message " + message);

        def value = getImplClass()

        value.run()

        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
    }
}
