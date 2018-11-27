/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-11-27 15:20
 * @Description 节点模型
 */
public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
