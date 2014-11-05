package algorithmsPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PracticeGeneric<T> {

	private T re;
    private T im;

    public PracticeGeneric(T re, T im) {
        this.re = re;
        this.im = im;
    }

    public T getReal() {
        return re;
    }

    public T getImage() {
        return im;
    }

    public String toString() {
        return "(" + re + ", " + im + ")";
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PracticeGeneric<Integer> test = new PracticeGeneric<>(1, 2);
//		System.out.println(test.getReal());
//		System.out.println(test.getImage());
		
		//practice set iteration
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(3);
		set.add(15);
		set.add(1);
		set.add(15);
		set.add(-4);
		
		for(Iterator it = set.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		
	}

}
