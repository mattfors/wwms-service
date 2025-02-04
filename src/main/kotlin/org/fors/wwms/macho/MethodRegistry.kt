package org.fors.wwms.macho

import java.lang.reflect.Method

object MethodRegistry {
    private val methodsMap = mutableMapOf<String, Method>()

    // Register method by name and method object
    fun registerMethod(methodName: String, method: Method) {
        methodsMap[methodName] = method
    }

    // Get method by name
    fun getMethod(methodName: String): Method? {
        return methodsMap[methodName]
    }

    fun isMethodRegistered(methodName: String): Boolean {
        return methodsMap.containsKey(methodName)
    }
}
