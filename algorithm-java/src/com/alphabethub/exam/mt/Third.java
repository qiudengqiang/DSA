package com.alphabethub.exam.mt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> arr = new ArrayList<Node>(n);
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            String direction = sc.next();
            arr.add(new Node(position, direction, null));
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).val);
        }
    }

    private static void move(Node node) {
        if ("R".equals(node.direction)) {
            node.val++;
        }else {
            node.val--;
        }
    }

    private static class Node {
        int val;
        String direction;
        boolean isBoom;
        Node next;

        public Node(int val, String direction, Node next) {
            this.val = val;
            this.direction = direction;
            this.next = next;
        }
    }
}
