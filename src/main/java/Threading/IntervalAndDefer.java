package Threading;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class IntervalAndDefer {

	static List<String> list = Arrays.asList("123","sfwr");
	
	public static void main(String[] args) {
		
		Observable.defer(()->Observable.fromIterable(list)).subscribe(x-> System.out.println(x));
		list= Arrays.asList("a");
		//list.add("qww");
		Observable.defer(()->Observable.fromIterable(list)).subscribe(x-> System.out.println(x));
	}
}
