package variable


/**
 * Created by sunnyDay on 2019/10/9 20:40
 *
 */

//------------------ list列表的定义------------------------------------------------
def list = [1, 2, 3, 4, 5] // 定义了个list 默认为arrayList
println(list.size()) //5
println(list.class) //class java.util.ArrayList

// 如上的定义方式占用了数组的方式，如何定义数组？
// 1、只需使用as 关键字强转即可。
//2、使用强类型定义

def array = [1, 2, 3] as int[]
println(array.class)

int[] arr2 = [1, 2, 3]
println(arr2.class)


//--------------------------------------列表的操作（主要是带闭包为参数的方法）----------------------------------------
// 1、列表排序

def sortList = [1, 3, 5, 2, 10, 8, -5, 4]
/*
java 提供了两种快速方式：
Collections.sort(list)
Collections.sort(sortList,Comparator) // 自定义比较器方式
*/

println sortList.sort()// groovy 提供1，默认从小到大。

println sortList.sort {
    a, b ->
        a == b ? 0 :
                Math.abs(a) > Math.abs(b) ? 1 : -1
} // 自定义比较器方式，参数为闭包。（这里按照绝对值大小排序）


// 2、查找（主要看结合闭包的方法）

def findList = [1, 3, 5, 8, "a"]

println findList.find { //这里查找第一个出现的偶数
    return it % 2 == 0
}

// 其他方法：
// min最小值
// max 最大值
// count 统计
//findAll 查找
//any 存在满足
//every 每个满足
// (这些也可以传参闭包Closure，指定自己的规则)


// ------------------------------------------map 映射的定义----------------------------------------------

// 定义： [key1:value1,key2,value2、、、、] 就代表map\

def map = [red: "red", green: "green", blue: "blue"]

// value的访问（java的get）
println map.red
println map["red"]

// 设置value（java的set，但是更能相当于set+add）
map.red = "new red"
map.black = "black" // 找不到对应的键时，会把新的键值对添加到map。

println(map.toMapString())
println(map.getClass()) // class java.util.LinkedHashMap 默认，不想默认就显示声明，或者使用as转换。
// 这里为啥使用getClass，而不是.class 因为使用点class时会寻找键为class的map键值对。

// 注意点： 定义时key尽量使用String或者Number类型（默认为单引号不可变字符串）

// -------------------------------------------------map的常用操作----------------------------------------------------

def student = [1: [name: "Tom", age: 18],
               2: [name: "Jerry", age: 23],
               3: [name: "Kate", age: 18]]

// 1、遍历 each
println student.each {
        //闭包方式遍历
    def stu -> println("name:" + stu.key + "age:" + stu.value)
}

println student.each {
        //直接遍历：key  value
    key, valu -> println("name:" + key + "age:" + valu)
}

// 2、map的查找  list的方法一致

// 其他方法：
//find
// min最小值
// max 最大值
// count 统计
//findAll 查找
//any 存在满足
//every 每个满足
// (这些也可以传参闭包Closure，指定自己的规则)


//3、分组  groupby
println(student.groupBy {
    def stu -> return stu.value.age > 20 ? "成年" : "未成年"
}) //[未成年:[1:[name:Tom, age:18], 3:[name:Kate, age:18]], 成年:[2:[name:Jerry, age:23]]]

// ==========================================范围

def range = 10..20 // Range 类为list的子类：public interface Range<T extends Comparable> extends List<T>

println(range[0])
// from \to获得对应收尾元素
println(range.from)
println(range.to)

// 遍历方式：1、闭包each 2、使用for

println("each style :")
println(range.each {
    print(it+" ")
})

println("for style : ")
for (i in range){
   print(i+" ")
}


// 2 switch case 的case语句可以为范围，满足条件的变量即可执行擦语句。
