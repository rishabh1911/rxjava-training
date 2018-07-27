import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class FirstTest {

	public static void main(String[] args) {

		Observable<String> source = Observable.create(emitter -> {
			emitter.onNext("Apple");
			System.out.println("Apple sent");
			emitter.onNext("Orange");
			emitter.onNext("Mango");
			emitter.onNext("Papaya");
		});

		Consumer<String> consumer = s -> System.out.println(s);
		source.subscribe(consumer);

		//Shorter way
		//source.subscribe(System.out::println);

		Observable<Integer> source1 = Observable.create(emitter -> {
			try {
				emitter.onNext(Integer.parseInt(args[0]));
				emitter.onNext(Integer.parseInt(args[1]));
				emitter.onComplete();
			} catch(Exception e) {
				emitter.onError(e);
			}
		});
		
		//source1.subscribe(System.out::println,e -> e.printStackTrace());
		source1.map(no->no*2).subscribe(System.out::println,Throwable::printStackTrace);
		System.out.println("done");

	}
}
