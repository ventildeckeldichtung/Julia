import java.util.Objects;
public class Complex {
	public final double real;
	public final double imag;
	public Complex (double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	public Complex (double real) {
		this.real = real;
		this.imag = 0;
	}
	public Complex Multiply (Complex b) {
		double r = this.real*b.real - this.imag*b.imag;
		double c = this.real*b.imag + this.imag*b.real;
		return new Complex(r,c);
	}
	public Complex Square() {
		double r = this.real*this.real - this.imag*this.imag;
		double c = this.real*this.imag + this.imag*this.real;
		return new Complex(r,c);
		
	}
	public double abs() {
		return Math.sqrt(real*real+imag*imag);
	}
	public Complex add(Complex z)
	{
		return new Complex(
				this.real + z.real, this.imag + z.imag);
	}

	public Complex subtract(Complex z)
	{
		return new Complex(
				this.real - z.real, this.imag - z.imag);
	}
    public String toString() {
        if (imag == 0) return real + "";
        if (real == 0) return imag + "i";
        if (imag <  0) return real + " - " + (-imag) + "i";
        return real + " + " + imag + "i";
    }
}
