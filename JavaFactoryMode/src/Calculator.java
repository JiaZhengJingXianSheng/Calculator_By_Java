/**
 * @Author LYZ
 * @Date 2021/11/26 15:15
 */
public class Calculator {
    public static double calculate(double numberA , double numberB, String operate){
        Operation oper;
        oper = SimpleFactory.createOperation(operate);
        oper.set_numberA(numberA);
        oper.set_numberB(numberB);
        try {
            return oper.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate(1,2,"+"));
        System.out.println(calculate(1,2,"/"));
        System.out.println(calculate(1,0,"/"));
    }
}
