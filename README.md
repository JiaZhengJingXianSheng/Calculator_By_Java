# Calculator_By_Java
# Java简单工厂模式

参考书目 《大话设计模式》 程杰 清华大学出版社



我们在编写程序时为了容易修改，通常会用 **封装、继承、多态** 来降低程序的耦合度。

比如我们要实现一个简单的计算器功能，具体功能为传入两个数值和一个操作符，返回计算结果。

## 一、 抽象类创建

通常我们会在一个抽象类内部定义主要的信息，比如输出输出等。

```java
public abstract class Operation {
    private double _numberA = 0;
    private double _numberB = 0;

    public double get_numberA() {
        return _numberA;
    }

    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    public double get_numberB() {
        return _numberB;
    }

    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }

    public abstract double getResult() throws Exception;

}
```

我们定义一个抽象计算函数，方便我们在不同操作下覆写这个操作。

## 二、 定义运算

接下来我们分别定义各种运算，继承Operation的信息，并覆写计算函数 $getResult()$ 

```java
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return get_numberA() + get_numberB();
    }
}
```

```java
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        return get_numberA() - get_numberB();
    }
}
```

```java
public class OperationMul extends Operation{
    @Override
    public double getResult() {
        return get_numberA() * get_numberB();
    }
}
```

```java
public class OperationDiv extends Operation{
    @Override
    public double getResult() throws Exception {
        if(get_numberB() == 0) {
            throw new Exception("除数不能为0 ");
        }
        return get_numberA() / get_numberB();
    }
}
```

我们在除法过程中判断被除数是否为0，为零抛出异常。

## 三、 工厂定义

接下来定义一个简单的工厂，传入我们的运算符，进行判断，并返回第二步所定义的操作类

```java
public class SimpleFactory {
    public static Operation createOperation(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
```

## 四、 计算函数

定义计算函数，传入操作数以及操作符，在函数内部用第三步的工厂生成操作类，并设置 _ $ numberA$  和 _ $numberB$  ，最终调用计算函数并返回，即可实现所有功能。

```java
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
```

## 五、 测试

在主函数中调用 $calculate()$ 函数并打印

```java
public static void main(String[] args) {
        System.out.println(calculate(1,2,"+"));
        System.out.println(calculate(1,2,"/"));
        System.out.println(calculate(1,0,"/"));
    }
```

```运行结果
// 运行结果
3.0
0.5
0.0
java.lang.Exception: 除数不能为0 
	at OperationDiv.getResult(OperationDiv.java:9)
	at Calculator.calculate(Calculator.java:12)
	at Calculator.main(Calculator.java:22)
```

## 总结

用工厂模式我们可以降低维护成本，比如我们想增加一种运算，只需要用新运算去继承我们初始的抽象类，覆写计算函数，并在工厂中加入我们的操作即可，这大大降低了我们代码的耦合度。
