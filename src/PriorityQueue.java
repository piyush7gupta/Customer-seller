
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {   
        this.capacity=capacity;
     queue= new NodeBase [capacity];
     
    
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        if(currentSize==0)
                return true;
            
            return false;
       
    }
	
    public boolean isFull() {
      
            if(currentSize==capacity)
                return true;
            else
                return false;
                     
    }

    public void enqueue(Node<V> node) {
        int i;
        if(queue[capacity-1]==null)
        {
            for( i=capacity-2;i>=0;i--)
            {

                    if(queue[i]!=null)
                    {    
                        if(node.getPriority()>queue[i].getPriority())
                        {
                            queue[i+1]=queue[i];
                        }
                        else
                        break;
                    }

            }

            if(i<capacity-1)
            {
                queue[i+1]=node;
                currentSize++;
            }
        }
        return;
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
        
            
           NodeBase<V> n1=null;
           int i=0;
           while(queue[i]!=null  )
           {
               i++;
           if(i>=capacity)
               break;
           }
            if(i==0)
                return n1;
            else
            {
                n1=queue[i-1];
                queue[i-1]=null;
            //NodeBase<V> n=queue[currentSize-1];    
            //queue[currentSize-1]=null;
            currentSize--;
            return n1;
            }
            /*
            NodeBase<V> n=queue[currentSize-1];    
            queue[currentSize-1]=null;
            currentSize--;
            return n;*/

            
            
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i+1].show();
	}
    }
}

