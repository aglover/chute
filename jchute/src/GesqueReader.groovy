import net.greghaines.jesque.ConfigBuilder;


import net.greghaines.jesque.worker.WorkerImpl;
import static net.greghaines.jesque.utils.JesqueUtils.entry;
import static net.greghaines.jesque.utils.JesqueUtils.map;

/**
 * Created by IntelliJ IDEA.
 * User: aglover
 * Date: 10/14/11
 * Time: 4:56 PM
 */
class GesqueReader {


    static void main(String[] args) throws Exception {

        println("running Groovy example!!")
        // Configuration
        def config = new ConfigBuilder().build();

        DynamicClazz.metaClass.static.getImplClass << { return new JDynamicClazz("hello world!!!"); }

        // Start a worker to run jobs from the queue
        def worker = new WorkerImpl(config,
                Arrays.asList("prod_android_build_events"), map(entry("DynamicClazz", DynamicClazz.class)));
        final Thread workerThread = new Thread(worker);
        workerThread.start();

        // Wait a few secs then shutdown
        try { Thread.sleep(5000); } catch (Exception e) {} // Give ourselves time to process
        worker.end(true);
        try { workerThread.join(); } catch (Exception e) { e.printStackTrace(); }


    }

}
