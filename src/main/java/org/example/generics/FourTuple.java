package org.example.generics;

public class FourTuple <A,B,C,D> extends ThreeTuple<A,B,C>{
    public final C fourth;
    public FourTuple(A a,B b,C c,D d){
        super(a,b,c);
        fourth = c;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth="+fourth+
                '}';
    }
}
