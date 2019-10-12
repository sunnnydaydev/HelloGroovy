package variable

import com.sun.corba.se.spi.ior.IdentifiableFactory

/**
 * Created by sunnyDay on 2019/10/9 19:20
 *
 */
//clouserPlus.groovylei 源文件中

// 1、类中或者方法中定义
def close = {
    println("闭包" + this)
    println("闭包" + owner)
    println("闭包" + delegate)
}
close.call()
/*
log:clouserPlus的对象内存地址
闭包variable.clouserPlus@58d75e99
闭包variable.clouserPlus@58d75e99
闭包variable.clouserPlus@58d75e99
*/


// 2、闭包中执行闭包
def close1 = {

    def close2 = {
        println("闭包中的闭包：" + this) // 闭包定义处的类（不可指向闭包对象）
        println("闭包中的闭包：" + owner) // 指向最近的对象（可以指向闭包对象）
        println("闭包中的闭包：" + delegate)//默认情况下指向最近的对象（可以指向闭包对象）
    }
    close2.call()
}

close1.call()

/*
闭包中的闭包：variable.clouserPlus@194bcebf
闭包中的闭包：variable.clouserPlus$_run_closure2@32502377
闭包中的闭包：variable.clouserPlus$_run_closure2@32502377
*/

// 3、修改delegate的默认指向
def close3 = {

    def close4 = {
        println("修改delegate：" + this)
        println("修改delegate：" + owner)
        println("修改delegate：" + delegate) //打印数值和owner不在一致
    }
    close4.delegate = new clouserPlus()
    close4.call()
}

close3.call()

/*修改delegate：variable.clouserPlus@53ce1329
修改delegate：variable.clouserPlus$_run_closure3@67f639d3
修改delegate：variable.clouserPlus@6253c26
*/


// 闭包的委托策略

class Stu {

    String name
    public Stu(String name) {
        this.name = name
    }

    def setName = { println("My name is $name") }
    void printName() {
        setName.call()
    }

}

class Per{
    String name
    public Per(String name) {
        this.name = name
    }
}

def stu = new Stu("Tom")
def per = new Per("Jerry")
// 1、正常情况下
stu.printName()//My name is Tom

// 2、更改闭包中delegate的指向
stu.setName.delegate = per
// 修改委托策略
stu.setName.resolveStrategy=Closure.DELEGATE_FIRST// 默认为OWNER(OWNER_FIRST)指向的对象，此句代码注释。则结果还是My name is Tom
stu.printName()// My name is Jerry

// 理解：调用的还是原类中的方法，知识闭包内的逻辑发生了改变。

