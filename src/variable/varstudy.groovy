package variable

import org.codehaus.groovy.runtime.StringGroovyMethods

/**
 * Created by sunnyDay on 2019/10/8 20:33
 */
//1、变量--------------------------------------------
int a = 10

double b = 2.11

def c = 1.23 // 默认为大数据类型

println(a.class) //class java.lang.Integer

println b.class //class java.lang.Double

println c.class //BigDecimal

//2、字符串-------------------------------------------------


def s = "test"   // 弱语言类型
    s = 10      //自动修改推断类型

println(s.class)

def string = 'a string ' // groovy中单引号也可以定义字符创与双引号一致。（这种没有格式与双引号一致，例如你换行时系统给你以加号拼接）

def three = ''' three'''  // 三个单引号也行（这种有格式，内容是啥打印出原始格式内容，换行啥的保留原始格式）

//三种定义方式几乎差不多，结果都是String类型，一般双引号方式常用。


println("$string")  // 双引号定义的为可扩展字符串（这时这个类是GString类型，也就是使用$变量或者表达式的方式得到的字符串为GString类型）

//String和GString可以互相转化，直接使用（String和GString不必可以区分）


//===================================StringGroovyMethods类的一些方法


//1、center 方法
def str= "groovy"
println str.center(8,"a")//agroovya  字符串居中，两边填充指定字符
println str.center(10)//字符串居中,两边填充空格
// padLeft方法。和center方法类似，只是从左边填充
//padRight方法。和center padLeft 类似。只是从右面填充

//2、比较方法、操作符
def str2 = "HAha"
println str2.compareTo(str) // 推荐使用  str2<=>str (这个运算符底层就是compareTo源码)
println(str2>str)


// 3、获取指定索引的字符
println str.getAt(0) // 写法1
println(str[0]) // 写法2 和kotlin类似
println(str[0..1]) // 还可以传范围

// 4 减法（去掉指定字符串）
println(str.minus("oo")) // 推荐使用减号 - 即  str-"oo"

//5、其他常见方法
println(str.reverse()) // 翻转
println(str.capitalize()) // 首字母大写
println(str.isNumber()) // 是否是数字类型的字符串
println(str.toInteger()) // 转换为指定类型  str.toXXX  （类型必须正确都是才可以转换）








