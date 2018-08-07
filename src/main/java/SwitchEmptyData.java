
import io.reactivex.Observable;

public class SwitchEmptyData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.just("test", "xxx", "ddd").filter(x->x.length()>4)
		.switchIfEmpty(Observable.just("apple","orange")).subscribe(System.out::println);
		
		System.out.println("\n\n\n\n\n");
		Observable.just("test", "xxx", "ddd").filter(x->x.length()>=4)
		.switchIfEmpty(Observable.just("apple","orange")).subscribe(System.out::println);
	}

}