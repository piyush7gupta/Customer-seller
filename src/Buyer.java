import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    int catalogSize;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...
        
        this.lock=lock;
        this.catalog=catalog;
        this.catalogSize=catalogSize;
        this.full=full;
        this.empty=empty;
        this.setSleepTime(sleepTime);
        this.setIteration(iteration);
        
    }
    public void buy() throws InterruptedException {
        lock.lock();
	try {
            //TODO Complete the try block for consume method
            // ...
            
            while(catalog.size()==0)
            { empty.await();}
            
            if(catalog.size()!=0)
            {
                NodeBase<Item> n;
                
                if(!catalog.isEmpty())
                {
                    n= (NodeBase<Item>)catalog.dequeue();
                    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
                    n.show(); // DO NOT REMOVE (For Automated Testing)
                    full.signalAll();
                }
                
            }
            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            lock.unlock();
            //TODO Complete this block
	}
    }
}
