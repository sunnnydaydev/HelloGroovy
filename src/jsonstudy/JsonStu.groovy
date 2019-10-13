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

def userList =  jsonSlurper.parseText(json)
println(userList[0].name) //


//====================xml===================

// 1、解析