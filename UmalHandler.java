import java.util.*;


public class UmalHandler{
	
	private final int squares;
	private final HashMap<List<Integer>,Integer> stored ; 
	
	
	public UmalHandler(int squareCt){
		this.squares = squareCt;
		stored = new HashMap<List<Integer>,Integer>();
		for(int i = 0; i <= this.squares; i++ ){
			stored.put(arrToL(spTC(i)),new Integer(i));
		}
	}
	
	
	private static List<Integer> arrToL(int[] arr){
		List<Integer> L = new ArrayList<Integer>();
		for(int x : arr){
			L.add(new Integer(x));
		}
		return L;
	}
	
	public static int[] spTC(int n){
		Complex i = new Complex(0,1);
		int p = (int)Math.sqrt(4*n + 1);
		int q = n - (int)(p*p/4);
		
		Complex t1 = new Complex(0,1);
		for(int j = 1; j < p; j++){
			t1 = t1.times(i);
		}
		t1 = t1.times(new Complex(q,0));
		
		int t2 = (int)((p+2)/4);
		int t3 = (int)((p+1)/4);
		
		Complex t4 = (new Complex(t3,0)).times(i);
		
		Complex t5 = (new Complex(t2,0)).minus(t4);
		
		Complex t6 = new Complex(0,1);
		for(int j = 1; j < p-1; j++){
			t6 = t6.times(i);
		}
		
		Complex t7 = t5.times(t6);
		
		Complex total = t7.plus(t1);
		
		int[] out = {(int)total.re(), (int)total.im()};
		return out;
		
	}	
	
	public int cTSP(int[] loc){
		Integer x = stored.get(arrToL(loc));
		return x.intValue();
	}
	
	public static void main(String[]args){
		int num = 90;
		UmalHandler handler = new UmalHandler(num);
		
		
		for(int i = 0; i < num; i++){
			int[] loc = handler.spTC(i);
			int locn = handler.cTSP(loc);
			System.out.println(i + " " + Arrays.toString(loc) + " " + locn);
		}
		
	}
	
}

class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude and angle/phase/argument
    public double abs()   { return Math.hypot(re, im); }  // Math.sqrt(re*re + im*im)
    public double phase() { return Math.atan2(im, re); }  // between -pi and pi

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // scalar multiplication
    // return a new object whose value is (this * alpha)
    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // return a new Complex object whose value is the conjugate of this
    public Complex conjugate() {  return new Complex(re, -im); }

    // return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }
    


    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }



    // sample client for testing
    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("Re(a)        = " + a.re());
        System.out.println("Im(a)        = " + a.im());
        System.out.println("b + a        = " + b.plus(a));
        System.out.println("a - b        = " + a.minus(b));
        System.out.println("a * b        = " + a.times(b));
        System.out.println("b * a        = " + b.times(a));
        System.out.println("a / b        = " + a.divides(b));
        System.out.println("(a / b) * b  = " + a.divides(b).times(b));
        System.out.println("conj(a)      = " + a.conjugate());
        System.out.println("|a|          = " + a.abs());
        System.out.println("tan(a)       = " + a.tan());
    }

}