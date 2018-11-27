/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-11-27 14:51
 * @Description 实现简单的单链表
 */
public class SinglyLinkedList {

    private Node head = null;

    private int size;

    /**
     * 向尾部添加节点，返回当前索引
     * @param data
     * @return
     */
    public int addNode(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return size++;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return size++;
    }

    /**
     * 在指定索引插入元素，返回插入的元素索引
     * @param index
     * @param data
     * @return
     */
    public int insertNode(int index,int data) {
        /**
         * 如果插入的位置在头部或者在头部之外，默认向头部插入
         */
        if (index >= size) {
            addNode(data);
            return size;
        }
        /**
         * 如果插入的位置在尾部或者在尾部之外，默认向尾部插入
         */
        Node node = new Node(data);
        if (index <= 0) {
            node.next = head;
            head = node;
            return 0;
        }
        /**
         * 如果插入的位置在中间，则把当前节点的后继指向右边，当前节点的前驱指向左边
         */
        Node temp = head;
        int i = 0;
        while (temp.next != null) {
            if (++i == index) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
        return index;
    }

    public void printAll() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data+"\n");
    }




    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        System.out.println(linkedList.insertNode(-177,9));
        linkedList.printAll();
    }
}
