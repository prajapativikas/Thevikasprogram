public class Jcounterstatic {
	static int count = 0;// will get memory only once and retain its value

	Jcounterstatic() {
		count++;
		System.out.println(count);
	}

	public static void main(String args[]) {

		Jcounterstatic c1 = new Jcounterstatic();
		Jcounterstatic c2 = new Jcounterstatic();
		Jcounterstatic c3 = new Jcounterstatic();

	}
}
