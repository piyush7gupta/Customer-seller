import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	int catalogSize;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
        // ...
        this.setSleepTime(sleepTime);
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalog=catalog;
        this.inventory=inventory;
        this.catalogSize=catalogSize;
        
    }
    
    public void sell() throws InterruptedException {
        lock.lock();
	try {
          
            while(catalog.size()==catalogSize)
            {
                full.await();
            }
         
            if(inventory.size()!=0)
            {       
              
                Node<Item> n;
                
                if(!inventory.isEmpty())
                {
                n=(Node<Item>)inventory.dequeue();
                //System.out.println(catalog.isFull()+" "+"piyush"+ " "+catalog.size()+" "+catalogSize);
                if(!catalog.isFull())
                catalog.enqueue((Node<V>)n);
                
                }
            
            empty.signalAll();
             
            
               
            }
             
            //TODO Complete the try block for produce method
            // ...
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            lock.unlock();
            //TODO Complete this block
	}		
    }
}
