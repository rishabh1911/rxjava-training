 import io.reactivex.Observable;
 
public class MapReduceTest {
 
       public static void main(String[] args) {
              Observable.range(1, 10).filter(x->x%3==0).map(x->x*x).reduce((x,y)->x+y).subscribe(System.out::println);
       }
}