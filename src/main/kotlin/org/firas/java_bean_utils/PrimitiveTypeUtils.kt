package org.firas.java_bean_utils

/**
 *
 * @author Wu Yuping
 */
internal fun isPrimitiveType(clazz: Class<*>): Boolean {
    return when (clazz) {
        Int::class.javaPrimitiveType,
        Char::class.javaPrimitiveType,
        Byte::class.javaPrimitiveType,
        Long::class.javaPrimitiveType,
        Double::class.javaPrimitiveType,
        Float::class.javaPrimitiveType,
        Short::class.javaPrimitiveType -> true

        else -> false
    }
}

internal fun getObjectType(clazz: Class<*>): Class<*> {
    return when (clazz) {
        Int::class.javaPrimitiveType -> Int::class.javaObjectType
        Char::class.javaPrimitiveType -> Char::class.javaObjectType
        Byte::class.javaPrimitiveType -> Byte::class.javaObjectType
        Long::class.javaPrimitiveType -> Long::class.javaObjectType
        Double::class.javaPrimitiveType -> Double::class.javaObjectType
        Float::class.javaPrimitiveType -> Float::class.javaObjectType
        Short::class.javaPrimitiveType -> Short::class.javaObjectType
        else -> clazz
    }
}

internal fun getPrimitiveType(clazz: Class<*>): Class<*>? {
    return when (clazz) {
        Int::class.javaObjectType -> Int::class.javaPrimitiveType
        Char::class.javaObjectType -> Char::class.javaPrimitiveType
        Byte::class.javaObjectType -> Byte::class.javaPrimitiveType
        Long::class.javaObjectType -> Long::class.javaPrimitiveType
        Double::class.javaObjectType -> Double::class.javaPrimitiveType
        Float::class.javaObjectType -> Float::class.javaPrimitiveType
        Short::class.javaObjectType -> Short::class.javaPrimitiveType
        else -> null
    }
}
