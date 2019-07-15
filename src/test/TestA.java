package test;


public class TestA {
    private int a = 1;
    public void asay(){
        TestB b = new TestB();
        b.bsay();
    }

    class TestB{
        public void bsay(){
            System.out.println("内部类方法");
        }
    }
}
interface OutInterface{
    void f();
}

class CCC{
    public static void main(String[] args) {
        TestA testA =new TestA();
        testA.asay();
        TestA.TestB testB = testA.new TestB();
        testB.bsay();
    }

}