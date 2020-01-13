// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase[] queue;
    private int capacity, currentSize, front, rear;
    private NodeBase n=null;
    public Queue(int capacity) 
    {    
            queue = new NodeBase[capacity];
            this.capacity=capacity;
            front=0;
            rear=0;
            
            
    }

    @Override
    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
            if(currentSize==0)
                return true;
            
            return false;
       
    }
	
    public boolean isFull() {
     
        if(rear==capacity)
            return true;
        else
            return false;
    }

    public void enqueue(Node<V> node) {
        
        if(rear<capacity && rear>=0)
        
        {
            queue[rear]=node;
            rear++;
            currentSize++;
            return;
        }
    }

    public NodeBase<V> dequeue() {
        
        if(capacity>0)
        {
            n=queue[0];
           for(int i=0;i<capacity-1;i++)
           {
               queue[i]=queue[i+1];
           }
           if(capacity>0)
           queue[capacity-1]=null;
           if(rear!=0)
           { rear--; 
            currentSize--;}
        }
            return n;

    }

}

