package variable

/**
 * Created by sunnyDay on 2019/10/9 11:09
 *
 */
// switch case  扩展    一句话case可以为任意类型的对象变量语句
def  a = 3.14159
def result

switch (a){
    case "hello"://字符串
        result = "fond hello"
        break
    case [1,2,3,"test"]://列表
        result = "fond list"
        break
    case 10..30: //范围区间（和kotlin写法一致，有kt基础这里会明白）
        result = "fond range"
        break
    case Short:
        result = "fond object type -> Short"
        break

    case BigDecimal:
        result = "fond object type -> BigDecimal"
        break

    default:
        result = "fond default value"
        break
}

println(result) //fond object type -> BigDecimal


// -------------------------for 循环-----------------------

//1、范围循环（和kt一样）
def sum = 0
for (i in 1..10){
    sum +=i
}
println(sum)

//2、list 循环  [元素1、元素2、、、] 就代表list

sum = 0
for (i in[1,2,3,4]){
    sum +=i
}
println(sum)

// 3、对map循环   [key1:value1,key2,value2、、、、] 就代表map

sum = 0
for (i in ["Tom":20,"Amos":24,"jerry":18]){
    // 这里可以直接获得map的 key 获得value
    sum+= i.value
}
println(sum)


