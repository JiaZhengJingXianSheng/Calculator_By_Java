/**
 * @Author LYZ
 * @Date 2021/11/26 14:55
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return get_numberA() + get_numberB();
    }
}
