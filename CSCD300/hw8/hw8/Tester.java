public class Tester {

    public static void main(String[] args) throws Exception {

        LinkedList A = new LinkedList(); 
        LinkedList A2 = new LinkedList();

        int ramdomListSize = 50000;
        for(int i = 0; i < ramdomListSize; i++) {
            int randomInt = (int)(Math.random() * 3000000);
            A.addLast(randomInt);
            A2.addLast(randomInt);
        }

        //measure the time cost of merge sort
        double then = System.currentTimeMillis();
        A.MergeSort();
        double now = System.currentTimeMillis();
        System.out.println("Time cost in milliseconds for mergesort " + (now - then));
        System.out.println(A.isSorted()); //verify that your merge sort implementation works.
        System.out.println("Size of list A is: " + A.getSize());

        //measure the time cost of insertion sort
        then = System.currentTimeMillis();
        A2.InsertionSort();
        now = System.currentTimeMillis();
        System.out.println("Time cost in milliseconds for insertionsort " + (now - then));
        System.out.println(A2.isSorted() ); //verify that your insertion sort works.
        System.out.println("Size of list A2 is: " + A2.getSize());


    }//end of main
}//end of tester class


