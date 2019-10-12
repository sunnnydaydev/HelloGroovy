package variable

/**
 * Created by sunnyDay on 2019/10/9 14:04
 *
 */

// -----------------------闭包：一段代码块 {}---------------------

//1、 简单的定义调用
def clouser = { println("我是闭包") }
clouser.call() // 闭包调用方式1
clouser()// 闭包调用方式2

// 2、参数传递
// 定义(多个参数定义时，使用逗号隔开即可)
def test  = {String name ->println "我是带参数的闭包,参数值为:$name"}   // 使用-> 定义有参数的闭包，符号左边为参数定义，右边为闭包体。
// 调用
test.call("Tom") // 方式1：call 传参数即可
test("Kate") // 方式2：传参即可


// 3 闭包的默认参数  it
def defPar = {
    println("使用默认参数it,值为：$it")
}
defPar.call("default")  // 怎样更改默认参数？用户只需显式指定个参数即可。


//4、返回值
def returnValue = {
    return "我是返回值"
}
println(returnValue()) // 接收return的返回值


def returnNull = {
    println("不写return时返回：")
}
println(returnNull()) // 可以接收空返回值类型，返回结果为Null
