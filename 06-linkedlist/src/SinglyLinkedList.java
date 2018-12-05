import com.sun.org.apache.regexp.internal.REUtil;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-11-27 14:51
 * @Description 实现简单的单链表
 */
public class SinglyLinkedList {

    /**
     * 链表头结点
     */
    private Node head = null;

    /**
     * 链表大小
     */
    private int size;

    /**
     * 向尾部添加节点，返回当前索引
     *
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
     *
     * @param index
     * @param data
     * @return
     */
    public int insertNode(int index, int data) {
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

    /**
     * 根据所有删除链表节点，成功返回被删除的节点，失败则返回null
     *
     * @param index
     * @return
     */
    public Node deleteByIndex(int index) {
        /**
         * 判断索引是否越界
         */
        if (index >= 0 && index <= size - 1) {
            /**
             * 如果删除头结点的话则直接将当前头结点赋值为头结点的后代节点
             */
            if (index == 0) {
                Node t = head;
                head = t.next;
                size--;
                return t;
            }
            /**
             * 如果删除节点为中间某节点的话，则让其前节点的后代指向其后代节点
             */
            Node temp = head;
            int i = 0;
            while (temp.next != null) {
                if (++i == index) {
                    Node t = temp.next;
                    temp.next = t.next;
                    return t;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    /**
     * 查找链表中间结点，使用快慢指针的方法，当快指针指到空结点时，慢指针指的位置就是中间结点
     *
     * @return
     */
    public Node findMiddleNode() {
        if (head == null) {
            return head;
        }
        Node slowNode = head;
        Node quickNode = head;
        /**
         * quickNode.next == null是链表结点个数为奇数时，快指针已经走到最后了
         * quickNode.next.next == null是链表结点数为偶数时，快指针已经走到倒数第二个结点了
         */
        while (quickNode.next != null && quickNode.next.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return slowNode;
    }

    /**
     * 打印链表所有元素
     */
    public void printAll() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    /**
     * 对链表进行反转
     * 从头开始向后遍历，改变相邻结点的指向，所以用三个变量
     */
    public void reverseNode() {
        if (head == null || head.next == null) {
            return;
        }
        Node preNode = null;
        Node currNode = head;
        Node nextNode = null;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        head = preNode;
    }

    /**
     * 检查有无环
     * 首先设置两个指针，分别命名为fast和slow，fast指针每次向后移2步，slow指针每次向后移1步。
     * 如果，fast指针最后走到尾结点，则没有环。
     * 如果，fast指针和slow指针相遇，则证明有环。
     * @return
     */
    public boolean checkCircle() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);

        //模拟环
        /*Node x = linkedList.head.next;
        linkedList.head.next.next.next.next.next = x;*/
        //linkedList.printAll();
        //System.out.println(linkedList.insertNode(-177,9));
        //System.out.println(linkedList.deleteByIndex(4));
        //System.out.println(linkedList.findMiddleNode());
        //linkedList.reverseNode();
        System.out.println(linkedList.checkCircle());
    }
}
