package HashMap_;

import java.util.HashMap;
import java.util.Map;

class ListNode{
    int key;
    int value;
    ListNode pre;
    ListNode next;
    public ListNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCacheoff031 {
    //双向链表维护缓存使用顺序,头部是最少使用的元素,尾部是新使用的
    Map<Integer,ListNode> lrumap;
    ListNode tail;
    ListNode head;
    int capacity;
    public LRUCacheoff031(int capacity) {
        lrumap = new HashMap<>();
        //初始化双向链表
        tail = new ListNode(-1,-1);
        head = new ListNode(-1,-1);
        tail.pre = head;
        head.next = tail;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(lrumap.containsKey(key)){
            //更新双向链表,把对应节点挪到尾部
            deletNode(lrumap.get(key));
            insertTail(lrumap.get(key));
            System.out.println("tail:"+tail.pre.value);
            return lrumap.get(key).value;
        }

        else
            return -1;
    }

    public void put(int key, int value) {
        if(lrumap.containsKey(key)){
            ListNode node = lrumap.get(key);
            deletNode(lrumap.get(key));
            lrumap.get(key).value = value;
            insertTail(lrumap.get(key));
        }
        else{
            //如果容量不够
            if(lrumap.size()==this.capacity){
                //删除头节点
                int delkey = head.next.key;
                lrumap.remove(delkey);
                deletNode(head.next);
                System.out.println(delkey);
            }
            ListNode tmp = new ListNode(key,value);
            lrumap.put(key,tmp);
            insertTail(tmp);
        }
    }
    private void deletNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
//        node.pre = null;
//        node.next = null;
    }
    private void insertTail(ListNode node){
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
//        if(tail.value==-1){
//            tail.pre.next = node;
//            node.pre = tail.pre;
//            node.next = tail;
//            tail.pre = node;
//            return;
//        }
//        tail.next = node;
//        node.pre = tail;
//        tail = node;
    }

    public static void main(String[] args) {
        LRUCacheoff031 lRUCache = new LRUCacheoff031(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }


}
