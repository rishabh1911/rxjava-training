import io.reactivex.Observable;
 
import java.util.Arrays;
import java.util.List;
 
class Pair{
               private int first;
               private int second;
               public Pair(int first, int second) {
                       super();
                       this.first = first;
                       this.second = second;
               }
               public int getFirst() {
                       return first;
               }
               public void setFirst(int first) {
                       this.first = first;
               }
               public int getSecond() {
                       return second;
               }
               public void setSecond(int second) {
                       this.second = second;
               }
               @Override
               public int hashCode() {
                       // TODO Auto-generated method stub
                       return first^second;
               }
               @Override
               public boolean equals(Object obj) {
                       // TODO Auto-generated method stub
                       Pair p1=(Pair)obj;
                       boolean eq=false;
                       if(first==p1.first&&second==p1.second){
                               eq=true;
                       }
                       return eq;
               }
               @Override
               public String toString() {
                       return "Pair [first=" + first + ", second=" + second + "]";
               }
              
              
}
 
public class DistinctTest {
 
        public static void main(String[] args) {
               // TODO Auto-generated method stub
              
               List<Pair> pairs=Arrays.asList(new Pair(1,2),new Pair(4,2),new Pair(2,1),new Pair(1,2));
               Observable.fromIterable(pairs).distinct().subscribe(System.out::println);
              
 
        }
 
}
 