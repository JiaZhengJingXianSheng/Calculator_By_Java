/**
 * @Author LYZ
 * @Date 2021/11/26 14:58
 */
public class OperationMul extends Operation{
    @Override
    public double getResult() {
        return get_numberA() * get_numberB();
    }
}
