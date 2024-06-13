import java.util.*;

class complex{
    int real;
    int imag;
    
    complex(int real, int imag){
        this.real=real;
        this.imag=imag;
    }

    public static complex add(complex a, complex b){
        return new complex((a.real + b.real), (a.imag + b.imag));
    }

    public static complex product(complex a, complex b){
        return new complex(((a.real*b.real)-(a.imag*b.imag)),((a.real*b.imag)+(a.imag*b.real)));
    }

    public static complex diff(complex a, complex b){
        return new complex(a.real-b.real, a.imag-b.imag);
    }

    public void printComplex(){
        if(real==0 && imag!=0){
            System.out.println(imag + "i");
        }else if(imag==0 && real!=0){
            System.out.println(real);
        }else{
            System.out.println(real + "+" + imag + "i");
        }
    }
}

public class oops {
    public static void main(String args[]){
        complex a=new complex(4,5);
        complex b=new complex(9, 4);

        complex c=complex.add(a,b);
        complex d=complex.product(a,b);
        complex e=complex.diff(a,b);

        c.printComplex();
        d.printComplex();
        e.printComplex();
    }
    
}
