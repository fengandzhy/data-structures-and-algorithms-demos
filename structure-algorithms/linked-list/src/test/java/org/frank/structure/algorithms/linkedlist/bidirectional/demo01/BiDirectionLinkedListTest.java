package org.frank.structure.algorithms.linkedlist.bidirectional.demo01;

import org.frank.structure.algorithms.linkedlist.bidirectional.HeroNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BiDirectionLinkedListTest {

    @Test
    public void testAdd(){        
        BiDirectionLinkedList biDirectionLinkedList = new BiDirectionLinkedList();
        
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");

        biDirectionLinkedList.add(node1);
        biDirectionLinkedList.add(node2);
        biDirectionLinkedList.add(node3);
        biDirectionLinkedList.add(node4);
        biDirectionLinkedList.add(node5);

        assertEquals(5,biDirectionLinkedList.size());
        biDirectionLinkedList.print();
        
        HeroNode node = biDirectionLinkedList.get(2);
        assertEquals("吴勇",node.getName());
        assertEquals("公孙胜",node.getNext().getName());
        assertEquals("卢俊义",node.getPre().getName());
    }

    @Test
    public void testGetNodeByNumber(){
        BiDirectionLinkedList biDirectionLinkedList = new BiDirectionLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");

        biDirectionLinkedList.add(node1);
        biDirectionLinkedList.add(node2);
        biDirectionLinkedList.add(node3);
        biDirectionLinkedList.add(node4);
        biDirectionLinkedList.add(node5);

        HeroNode node = biDirectionLinkedList.getNodeByNumber(2);
        assertEquals("卢俊义",node.getName());

        node = biDirectionLinkedList.getNodeByNumber(6);
        assertNull(node);
    }

    @Test
    public void testDeleteByNumber(){
        BiDirectionLinkedList biDirectionLinkedList = new BiDirectionLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3,"吴勇", "智多星");
        HeroNode node4 = new HeroNode(4,"公孙胜", "入云龙");
        HeroNode node5 = new HeroNode(5,"关胜", "大刀");

        biDirectionLinkedList.add(node1);
        biDirectionLinkedList.add(node2);
        biDirectionLinkedList.add(node3);
        biDirectionLinkedList.add(node4);
        biDirectionLinkedList.add(node5);

        biDirectionLinkedList.deleteByNumber(3);
        assertEquals("卢俊义",biDirectionLinkedList.get(1).getName());
        assertEquals(4,biDirectionLinkedList.size());        
    }

    @Test
    public void testExists(){
        BiDirectionLinkedList biDirectionLinkedList = new BiDirectionLinkedList();
        HeroNode node1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode node2 = new HeroNode(1,"宋江", "及时雨");
        biDirectionLinkedList.add(node1);
        RuntimeException runtimeException = Assert.assertThrows(RuntimeException.class ,()-> biDirectionLinkedList.add(node2));
        assertTrue(runtimeException.getMessage().contains("The node has already existed."));
    }
}
