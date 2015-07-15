package licc.utils.questions.hackerrank;

import java.util.*;

/**
 * Created by user on 2015/7/15.
 */
public class MinAveWaitTime {
    /*
     * use a min heap sorted by customer.l , means each time choose a least-taken pizza to cook
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Customer[] arr = new Customer[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = new Customer(in.nextInt(), in.nextInt());
        }
        Arrays.sort(arr, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.t - o2.t;
            }
        });
//        System.out.println(Arrays.toString(arr));
        PriorityQueue<Customer> h = new PriorityQueue<>(N, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.l - o2.l;
            }
        });

        int i = 0;
        long t = 0, wait = 0;
        while (i < N || !h.isEmpty()) {
            if (h.isEmpty()) {
                //when empty, offer the first come customer, notice that this may be more than one case
                h.offer(arr[i]);
                t = arr[i].t;
                int j = i + 1;
                while (j < N && arr[j].t == arr[i].t) {
                    h.offer(arr[j]);
                    j++;
                }
                i = j;
            }
            Customer curr = h.poll();
//            System.out.println(curr);
            t += curr.l;
            wait += (t - curr.t);
            while (i < N && arr[i].t <= t) {
                h.offer(arr[i]);
                i++;
            }
        }
        System.out.println(wait / N);
    }

}

class Customer {
    int t;
    int l;

    Customer(int t, int l) {
        this.t = t;
        this.l = l;
    }

//    @Override
//    public String toString() {
//        return "[" + this.t + "," + this.l + "]";
//    }
}
