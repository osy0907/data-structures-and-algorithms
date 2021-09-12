package data_structures.heap;

import java.util.ArrayList;
import  java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        this.heapArray = new ArrayList<Integer>();
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    public boolean move_up(Integer inserted_idx) {
        if (inserted_idx <= 1) {
            return false;
        }
        int parent_idx = inserted_idx / 2;
        return this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx);
    }

    public boolean insert(Integer data) {
        int inserted_idx, parent_idx;
        if (this.heapArray == null) {
            this.heapArray = new ArrayList<Integer>();
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        while (this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;
            Collections.swap(heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public boolean move_down(Integer popped_idx) {
        int left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 때
        if (left_child_popped_idx >= this.heapArray.size()) {
            return false;
            // CASE2: 오른쪽 자식 노드만 없을 때
        } else if (right_child_popped_idx >= this.heapArray.size()) {
            return this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx);
            // CASE3: 왼쪽, 오른쪽 자식 노드 모두 있을 때
        } else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                return this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx);
            } else {
                return this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx);
            }
        }
    }

    public Integer pop() {
        int returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if (this.heapArray.size() <= 1) {
            return null;
        }

        returned_data = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);
        popped_idx = 1;

        while (this.move_down(popped_idx)) {
            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            if (right_child_popped_idx >= this.heapArray.size()) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                    popped_idx = left_child_popped_idx;
                }
            } else {
                if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
        return returned_data;
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        System.out.println(heapTest.insert(10));
        System.out.println(heapTest.insert(8));
        System.out.println(heapTest.insert(5));
        System.out.println(heapTest.insert(4));
        System.out.println(heapTest.insert(20));
        System.out.println(heapTest.heapArray);
        System.out.println("pop value : " + heapTest.pop());
        System.out.println(heapTest.heapArray);
    }
}
