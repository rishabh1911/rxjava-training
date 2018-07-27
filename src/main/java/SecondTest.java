import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Observable;
// using consumers (not observers)
public class SecondTest {

	public static void main(String[] args) {
		
		System.out.println("Main: "+Thread.currentThread().getName());
		Observable<String> source = Observable.just("Apple","Orange","Observer Thread: "+Thread.currentThread().getName());
		
		source.map(String::toUpperCase).filter(s->s.length()>3).subscribe(x -> System.out.println("Observer: "+
				Thread.currentThread().getName()+" "+x));
		// all above is performed lazily
		
		//if we use operations like sorted then the whole operations has to wait.
		source.map(String::toLowerCase).filter(s->s.length()<6).sorted().subscribe(System.out::println);
		
		//we can even pass comparators
		Comparator<String> comparator = (s1,s2) -> s2.compareTo(s1);
		source.map(String::toUpperCase).filter(s->s.length()<6).sorted(comparator).subscribe(System.out::println);
		
		
		
		
		
		
		List<String> list = Arrays.asList("one","two","three","four","five");
		Observable<String> source2 = Observable.fromIterable(list);
		source2.filter(no->no.length()>3).map(no->no.toUpperCase()).subscribe(System.out::println);
	}
}
