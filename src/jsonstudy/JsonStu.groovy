package jsonstudy

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectstudy.Person

/**
 * Create by SunnyDay on 2019/10/13
 */

// ===========json====================

// 1、生成实体
def list = [new Person(name: "Tom", age: 10),
            new Person(name: "Kate", age: 12)]

def jsonString = JsonOutput.toJson(list) //直接转变为Json
println(jsonString)

println(JsonOutput.prettyPrint(jsonString)) // 格式化输出json

// ------------------------

// 2、json转实体

// 准备一份json数据
String json = "[{\"age\":10,\"name\":\"Tom\"},{\"age\":12,\"name\":\"Kate\"}]"
def jsonSlurper = new JsonSlurper()

def userList = jsonSlurper.parseText(json)
println(userList[0].name) //Tom

//====================xml===================

// 1、解析

String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<value>\n" +
        "    <books id=\"1\" type=\"android\">\n" +
        "        <book page=\"507\">\n" +
        "            <title>安卓开发艺术探索</title>\n" +
        "            <author>任玉刚</author>\n" +
        "        </book>\n" +
        "        <book page=\"507\">\n" +
        "            <title>第一行代码</title>\n" +
        "            <author>郭霖</author>\n" +
        "        </book>\n" +
        "        <book page=\"100\">\n" +
        "            <title>安卓进阶之光</title>\n" +
        "            <author>刘望舒</author>\n" +
        "        </book>\n" +
        "    </books>\n" +
        "\n" +
        "</value>"
def xmlSlurper = new XmlSlurper()
def value = xmlSlurper.parseText(xmlString) // 1、获得根节点对象

println value.books.book[0].title.text() //2、节点对象调用text()获得节点内的值

println value.books.book[0].@page // 3、对象@属性 直接访问这个属性值


def bklist = []

value.books.book.each {

    bk ->
        def pageCount = bk.@page
        if (pageCount == "507") {
            bklist.add(bk.title.text())
        }
}

//println bklist.toListString()

println value.depthFirst().findAll() {
    book -> return book.author.text() == "任玉刚"
}


def name= value.books.children().findAll {
    node -> node.@page == "507" && node.author.text() == "任玉刚"
}.collect {
    node -> return node.title.text()
}

println("name:$name")

//