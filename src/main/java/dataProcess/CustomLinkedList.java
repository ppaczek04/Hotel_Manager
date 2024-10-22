package dataProcess;

public class CustomLinkedList<E> {

    public class Node<E>{
        private E data;
        private Node<E> previous;
        private Node<E> next;

        public Node(){
            previous = null;
            next = null;
            this.data = null;
        }
        public Node(E data){
            previous = null;
            next = null;
            this.data = data;
        }
        public E getData(){return this.data;}
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public CustomLinkedList(){
        head = null;
        tail = null;
    }

    public void pushFront(E data){
        Node<E> curr_node = new Node<>(data);
        if(head == null){
            this.head = curr_node;
            this.tail = curr_node;
        }
        else{
            head.previous = curr_node;
            curr_node.next = head;
            head = curr_node;
        }
        size++;
    }
    public void pushBack(E data){
        Node<E> curr_node = new Node<>();
        if(head == null){
            this.head = curr_node;
            this.tail = curr_node;
        }
        else{
            tail.next = curr_node;
            curr_node.previous = tail;
            tail = curr_node;
        }
        size++;
    }

    public void deleteAtIndex(int index){
        int counter = 0;
        Node<E> checked_node = head;
        if(index < 0 || index >= size){
            System.out.println("Item at this index doesnt exist");
            return;
        }
        while(true){
            if(counter == index){
                if(checked_node == head){

                }
            }
            checked_node = checked_node.next;
            counter++;
        }
    }

}
