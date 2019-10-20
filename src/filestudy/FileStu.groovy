package filestudy

/**
 * Create by SunnyDay on 2019/10/20
 */

// 1、文件的读取(本工程下的一个iml文件)
def file = new File("../../HelloGroovy.iml")

// 遍历方式1(有点鸡肋)
file.eachLine {
    line -> println(line)
}

// 遍历方式2（快捷）
String text = file.getText()
println(file.getText())

println(file.readLines()) // 读取没行的结果放入了list集合中

// 读取指定数据(前100个字符)

println(file.withReader {
    reader ->
        char[] buf = new byte[100]
        reader.read(buf)
        return buf
})

// 文件的写
//def newFile = new File("../../HelloGroovy2.iml")
//if (!newFile.exists()) {
//    newFile.createNewFile()
//
//    newFile.withWriter {
//        write -> write.append(file.getText())
//    }
//}

// 对象的存储

//1、保存

def saveObject(Object object, String path) {
    def file = new File(path)
    if (!file.exists()) {
        file.createNewFile()
    }
    file.withObjectOutputStream {
        objectStream -> objectStream.writeObject(objectStream)
    }
}

// 读对象

def readObject(String path) {
    def obj = null
    def file = new File(path)
    if (!file.exists() || file == null) {
        return
    }
    file.withObjectInputStream {
        readObject ->
            obj = readObject.readObject()
    }
    return obj
}


