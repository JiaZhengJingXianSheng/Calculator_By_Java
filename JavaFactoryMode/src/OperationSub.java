/**
 * @Author LYZ
 * @Date 2021/11/26 14:57
 */
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return get_numberA() - get_numberB();
    }
}
