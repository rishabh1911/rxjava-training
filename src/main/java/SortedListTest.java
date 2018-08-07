import java.util.HashSet;
import java.util.List;

import io.reactivex.Observable;

public class SortedListTest {
	private static List<String> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.just("xxx","aaa","bbb","ddd").toSortedList((a,b)->b.compareTo(a)).subscribe(item->{
			list=item;
		});
		for(String s:list){
			System.out.println(s);
		}
		//Observable.just("xxx","aaa","bbb","ddd").toMap(a->a.substring(0, 1)).subscribe(System.out::println);
		Observable.just("xxx","aaa","bbb","ddd","rrrrrrr").toMultimap(a->a.length()).subscribe(System.out::println);
		
		Observable.just("xxx","aaa","bbb","bbb","ddd","rrrrrrr").collect(()->new HashSet<String>(), (s,item)->s.add(item))
		.subscribe(System.out::println);
		
		
	}

}