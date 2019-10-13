package objectstudy

import org.apache.tools.ant.taskdefs.Expand

/**
 * Create by SunnyDay on 2019/10/13
 */
ExpandoMetaClass.enableGlobally() // 注入的方法或者成员全局可用

def person = new Person(name: "Tom",age: 18)
println("name:${person.name}  age:${person.age}")
person.eat()

// 执行未定义的方法时

 person.cry()// 编译期通过，运行期：groovy.lang.MissingMethodException

 println person.cry()//你调用的方法名：cry,方法参数：[]

  Person.metaClass.sex = "male" // 为类动态添加属性
  println(new Person().sex)

  // 为类进行方法注入，传个闭包即可（栗子如下）

 // 添加
  Person.metaClass.strUpCase = {
     String str ->str.toUpperCase()
  }
   println new Person().strUpCase("string")

// 静态：和动态类似。只是多了个static关键字  Person.metaClass.static.方法\成员

