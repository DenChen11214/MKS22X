public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data2 = new MyLinkedListImproved[10];	
	for(int i = 0; i < data.size();i++){
	    System.out.println(data.get(i));
	    data2[Integer.parseInt((data.get(i) + "").substring((data.get(i) + "").length() - 1, (data.get(i) + "").length()))].add(data.get(i));
	    System.out.println(data2[0].get(0));
	}
	for(int i = 0; i < 10; i++){
	    for(int n = 0; n < data2[i].size(); n++){
		System.out.println(data2[i].get(n));
	    }
	}
    }
    public static void main(String[] args){
	MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
	l.add(0);
	l.add(0);
	l.add(1);
	l.add(5);
	l.add(4);
	l.add(82);
	l.add(23);
	l.add(3);
	radixsort(l);
    }
}
