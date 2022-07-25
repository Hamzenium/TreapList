
public class Tester_List {

	public static void main(String[] args) {
		
		TreapList<Integer> list = new TreapList<>();
//		list.add("0");
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
//		list.add("5");
//		list.add("6");
//		list.add("7");
//		list.add("8");
//		list.add("9");
//		list.add("10");
//		list.add("11");
//		System.out.println(list.root.key);
//		System.out.println(list.root.left.key);
//		System.out.println(list.root.left.right.key);
		
//		System.out.println(list.get(2));
//       System.out.println(list.remove(2));
//       System.out.println(list.get(3));
       for(int i =0; i<100;i++) {
    	   list.add(i,i);
       }
      
//       list.add(23, 200);

       System.out.println(list.get(23));
       System.out.println(list.remove(23));
       System.out.println(list.get(23));
		
		
		
		
		
//		System.out.println(list.root.right.left.data);
//		System.out.println(list.root.right.left.left.data);
		
	}


}
