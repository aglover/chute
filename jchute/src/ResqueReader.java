import net.greghaines.jesque.Config;
import net.greghaines.jesque.ConfigBuilder;
import net.greghaines.jesque.worker.Worker;
import net.greghaines.jesque.worker.WorkerImpl;
import static net.greghaines.jesque.utils.JesqueUtils.entry;
import static net.greghaines.jesque.utils.JesqueUtils.map;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: aglover
 * Date: 10/11/11
 * Time: 1:31 PM
 */
public class ResqueReader {


    public static void main(String[] args) throws  Exception{

        // Configuration
        final Config config = new ConfigBuilder().build();

        // Start a worker to run jobs from the queue
        final Worker worker = new WorkerImpl(config,
            Arrays.asList("prod_log_events"), map(entry("DynamicClazz", DynamicClazz.class)));
        final Thread workerThread = new Thread(worker);
        workerThread.start();

        // Wait a few secs then shutdown
        try { Thread.sleep(5000); } catch (Exception e){} // Give ourselves time to process
        worker.end(true);
        try { workerThread.join(); } catch (Exception e){ e.printStackTrace(); }



    }

}
