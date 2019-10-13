package objectstudy

/**
 * Create by SunnyDay on 2019/10/13
 */
class Person implements Action{
      String name
      int age

      def grow(){
          println("又涨了一岁")
      }

    @Override
    def run() {
        return null
    }

    /**
     * 一个方法找不到时会调用这个方法：用途框架中给出丢失方法提示。
     *@param name 要调用的方法名
     * @param args 要调用的方法参数
     * */
    @Override
    Object invokeMethod(String name, Object args) {
        return "你调用的方法名：$name,方法参数：$args"
    }

    /**
     * 二者存在时优先调用这个
     * */
    Object methodMissing(String name, Object args){
        return "你调用的方法名：$name,is Missing"
    }

}
