class Node{
    int data;
    Node next;
    //Constructor
    Node(int a){
        data=a;
        next=null;
    }
    //method getData
    public void getData(){
        System.out.println(data);
    }
}
class Main {
    public static void main(String[] args) {
        System.out.println("yashraj");
        Node a= new Node(21);
        System.out.println(a);
        a.getData();
        
        Node b= new Node(17);
       b.getData();
    }
}
