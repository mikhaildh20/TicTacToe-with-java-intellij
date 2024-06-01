public class TicTac {
    Node head;
    int[] box;
    int size;
    int output;
    private final static int MAX_SIZE = 9;
    private final static  int row = 3;
    private final static int column = 3;
    public TicTac(){
        this.head = null;
        this.size = MAX_SIZE;
    }

    public void insert(int val){
        Node node = new Node(val);
        if (head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void setIndex(int idx, int val){
        Node temp = head;
        for (int i = 0;i<MAX_SIZE;i++){
            if (i == idx){
                temp.value = val;
                break;
            }
            temp = temp.next;
        }
    }

    public int linedHorizontal(){
        box = new int[3];
        Node temp = head;
        output = 0;
        for (int i = 0;i < row;i++)
        {
            for (int j=0;j < column;j++)
            {
                box[j] = temp.value;
                temp = temp.next;
            }
            if (box[0] == box[1] && box[1] == box[2] && box[0] != 0){
                output = box[0];
                break;
            }
        }
        return output;
    }

    public int linedVertical(){
        box = new int[9];
        Node temp = head;
        output = 0;
        for (int i = 0;i<MAX_SIZE;i++){
            box[i] = temp.value;
            temp = temp.next;
        }
        for (int i = 0;i<column;i++){
            if (box[i] == box[i+3] && box[i+3] == box[i+6] && box[i] != 0){
                output = box[i];
                break;
            }
        }
        return output;
    }

    public int linedDiagonal(){
        box = new int[9];
        Node temp = head;
        output = 0;
        for (int i=0;i<MAX_SIZE;i++){
            box[i] = temp.value;
            temp = temp.next;
        }
        int i=0;
        if (box[i] == box[i+4] && box[i+4] == box[i+8] && box[i] != 0){
            output = box[i];
        }
        i=2;
        if (box[i] == box[i+2] && box[i+2] == box[i+4] && box[i] != 0){
            output = box[i];
        }
        return output;
    }

    public void clear(){
        head = null;
    }

    public static class Node{
        Node next;
        int value;

        public Node(int value){
            this.next = null;
            this.value = value;
        }
    }
}
