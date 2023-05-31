package com.search.springbootinit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 樊金亮
 * @date 2023/5/15
 */
public class MainTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        //System.out.println(queue.poll());
        if (queue.poll().equals(2)) {
            System.out.println("yes");
        }

        System.out.println(queue);

    }
}
