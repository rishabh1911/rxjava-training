import io.reactivex.Observable;

public class DeferTest {

	private static int start =1;
	private static int count =5;
	
	public static void main(String[] args) {
		
//		Observable<Integer> source = Observable.range(start, count);
//		source.subscribe(x->System.out.println("Subscriber1: "+x));
//		count = 10;
//		source.subscribe(x->System.out.println("Subscriber2: "+x));
		
		
		
		Observable<Integer> source2 = Observable.defer(()->Observable.range(start, count));
		source2.subscribe(x->System.out.println(Thread.currentThread().getName()+" Subscriber1: "+x));
		count = 10;
		source2.subscribe(x->System.out.println(Thread.currentThread().getName()+" Subscriber2: "+x));

	}

}
