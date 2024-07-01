public class complex{
    public static void main(String[] args) {
        complexnumber a=new complexnumber(4,5);
        complexnumber b=new complexnumber(8,9);

        complexnumber c=complexnumber.add(a,b);
        complexnumber d=complexnumber.diff(a,b);
        complexnumber e=complexnumber.product(a,b);

        c.printcomplex();
        d.printcomplex();
        e.printcomplex();
    }
}


class complexnumber {
    int real;
    int imag;

    public complexnumber(int real, int imag){
        this.real=real;
        this.imag=imag;
    }

    public static complexnumber add(complexnumber a, complexnumber b){
        return new complexnumber((a.real+b.real) , (a.imag + b.imag));
    }

    public static complexnumber diff(complexnumber a, complexnumber b){
        return new complexnumber((a.real-b.real) , (a.imag - b.imag));
    }

    public static complexnumber product(complexnumber a, complexnumber b){
        return new complexnumber(((a.real * b.real) - (a.imag*b.imag)) , ((a.real*b.imag)+(a.imag*b.real)));
    }

    public void printcomplex(){
        if(real==0 && imag!=0){
            System.out.println(imag + "i");
        }
        if(real!=0 && imag==0){
            System.out.println(real);
        }
        else{
            System.out.println(real + "+" + imag + "i");
        }
    }
}