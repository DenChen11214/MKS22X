public class Driver{
  public static void main(String[] args){


    //MOST IMPORTANT TEST........PARTITION!!!
    //(This could be more extensive ..... and better .... and A LOT MORE!)
    //(My Quick.partition returns the index num of PIVOT, and is inclusive of the last num)
    System.out.println("TESTING PARTITION");

    int[] tests = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};

    int ans = Quick.partition(tests, 0, tests.length - 1);
    System.out.println("Pivot: " + tests[ans] + " Index: " + ans);
    System.out.println("Pivot correct? " + checkPivot(tests, ans));
    toString(tests);


    int[] testt = {};
    ans = Quick.partition(testt, 0, 0);
    toString(testt);

    int[] testu = {1};
    ans = Quick.partition(testu, 0, 1);
    System.out.println("Pivot: " + testu[ans] + " Index: " + ans);
    toString(testu);


    int[] testv = {1,1};
    ans = Quick.partition(testv, 0, 1);
    System.out.println("Pivot: " + testv[ans] + " Index: " + ans);
    toString(testv);

    int[] testw = {2,1};
    ans = Quick.partition(testw, 0, 1);
    System.out.println("Pivot: " + testw[ans] + " Index: " + ans);
    toString(testw);

    int[] testx = {1,2};
    ans = Quick.partition(testx, 0, 1);
    System.out.println("Pivot: " + testx[ans] + " Index: " + ans);
    toString(testx);
    System.out.println("DONE!\n");



    //Borrowed most from K
    int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
    toString(test);
    ////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
    System.out.println("\nPRINTING LEAST TO GREATEST");
    for (int i = 0; i < test.length; i++){
      System.out.println(Quick.quickselect(test, i));;
    }
    System.out.println("DONE!\n");


    //Testing QuickSort
    System.out.println("TESTING QUICKSORT!");
    //General Case

    long start,end;
    start = System.currentTimeMillis();

    System.out.print("Before: ");
    int[] testy = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
    toString(testy);
    Quick.quicksort(testy);
    end = System.currentTimeMillis();

    System.out.print("aAfter: ");
    toString(testy);
    System.out.println("Time: " + (end-start) + "ms");

    //Edge Cases
    System.out.print("\nTESTING EDGY CASES!\n");

    int[] testz = {};
    System.out.print("Before: ");
    toString(testz);
    System.out.print("aAfter: ");
    Quick.quicksort(testz);
    toString(testz);
    System.out.println();

    int[] testa = {1};
    System.out.print("Before: ");
    toString(testa);
    System.out.print("aAfter: ");
    Quick.quicksort(testa);
    toString(testa);
    System.out.println();

    int[] testb = {1,1};
    System.out.print("Before: ");
    toString(testb);
    System.out.print("aAfter: ");
    Quick.quicksort(testb);
    toString(testb);
    System.out.println();

    int[] testc = {2,1};
    System.out.print("Before: ");
    toString(testc);
    System.out.print("aAfter: ");
    Quick.quicksort(testc);
    toString(testc);
    System.out.println();

    int[] testd = {1,2};
    System.out.print("Before: ");
    toString(testd);
    System.out.print("aAfter: ");
    Quick.quicksort(testd);
    toString(testd);
    System.out.println();

  }
}
