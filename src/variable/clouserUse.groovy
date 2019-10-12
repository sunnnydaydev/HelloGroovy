package variable

/**
 * Created by sunnyDay on 2019/10/9 14:42
 *
 */


//-------------------- 闭包的使用（常用方法）-------------------

// 方法内部不需要关注具体的逻辑，只需要按照固定的模板调用即可，具体的实现交付给调用者实现。和接口回调类似。
//使用：都是通过方法的调用，吧闭包当做方法的参数。




// 1、结合基本类型

// 求指定数字的阶乘 upto方式
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })  // 循环在upto内操作了（数字递增到number）
    return result
}

println(fab(5))

// 使用downTo方式

int fab2(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }// ，作为方法参数的最后一个时，闭包还可以放大括号外，
    // 闭包放方法外是groovy中常见的方式（number递减到数字）
    return result
}

println(fab2(5))


// 累积求和

int sum(int number) {
    int result = 0
    number.times { // times 内部循环是从0开始的
        num -> result += num
    }
    return result
}

println(sum(10))


// 2、字符串与闭包的结合

// 字符串的遍历 each方法
String s = "i am String 1"
s.each { //返回值就是调用者本身
    String temp-> print(temp)
}


// find方法  查找指定第一个字符串
println s.find{ // 看源码发现find的闭包必须为boolean 类型的返回值
    String temp -> temp.isNumber() // 第一个数字
}
// 对应方法 findAll 返回指定的所有字符串（返回一个collection集合）


// any 方法。   需要返回boolean类型的闭包
//字符串是否满足某种条件,有满足时返回true （对应方法为every，是否每一个字符串都满足）
println s.any{
    num->num.isNumber()
}


// collection   同一处理字符串
println s.collect{
    it.toUpperCase() // 所有大写
}




