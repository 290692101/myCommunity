package com.bbs.res;

/**简单工厂模式 返回对应的JsonResult
 *
 * 这个泛型的写法我没搞明白
 *
 *
 */
//调用类的静态方法不需要ComPonent
//@Component
//默认为单例 该方法类实现对返回结果的封装
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}

