package org.firas.java_bean_utils

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Read the value of a field in an object by using Java reflection API.
 *
 * This converter read the value of the field in the input bean by the
 * following:
 * 1. Find the public getter that follows the Java Bean Specification
 *    (e.g. the getter for `String userName` is
 *    `String getUserName()` and the getter for `boolean successful`
 *    is `boolean isSuccessful()`);
 * 2. If step 1 cannot find such getter and the field is of boolean
 *    type, also try to find the public getter that starts with "get"
 *    (e.g. `boolean getSuccessful()` for `boolean successful`);
 * 3. If the above steps fail to find a getter, also try to find the
 *    public getter that has the same name as the field;
 *    (e.g. `boolean successful()` for `boolean successful`)
 * 4. If the above steps fail to find a getter, set the field to
 *    accessible and call `Field.get(Object)`.
 *
 * @param <T> The type of the bean
 * @author Wu Yuping
 */
class BeanFieldGetter<T>(
    /**
     * Allow user to specify the class because the getter may be
     * overriden in the sub-class of the class that declares the
     * field
     */
    private val clazz: Class<T>,

    /**
     * The class that declares this field must be assignable from
     * the input `clazz`
     */
    private val field: Field,

    private val trySameNameGetter: Boolean,

    /**
     * Whether try to access the field by the API [Field#get(Object)]
     */
    private val tryFieldGetter: Boolean
) {
    constructor(clazz: Class<T>, field: Field, trySameNameGetter: Boolean):
            this(clazz, field, trySameNameGetter, true)

    constructor(clazz: Class<T>, field: Field):
            this(clazz, field, true, true)

    private var getter: Method? = null

    init {
        if (!this.field.declaringClass.isAssignableFrom(this.clazz)) {
            throw IllegalArgumentException(this.field.declaringClass.name +
                    " is not assignable from " + this.clazz.name)
        }

        val fieldName = this.field.name
        val fieldType = this.field.type
        val capitalFirst = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)
        val getterName = "get" + capitalFirst
        val booleanGetterName = "is" + capitalFirst

        val isBoolean = Boolean::class.javaPrimitiveType == fieldType ||
                Boolean::class.javaObjectType == fieldType

        do {
            if (isBoolean) {
                try {
                    val getter = clazz.getMethod(booleanGetterName)
                    if (getObjectType(getter.returnType).isAssignableFrom(getObjectType(fieldType))) {
                        this.getter = getter
                        break
                    }
                } catch (ex: NoSuchMethodException) {
                    // Do not need to handle
                }
            }

            try {
                val getter = clazz.getMethod(getterName)
                if (getObjectType(getter.returnType).isAssignableFrom(getObjectType(fieldType))) {
                    this.getter = getter
                    break
                }
            } catch (ex: NoSuchMethodException) {
                // Do not need to handle
            }

            if (this.trySameNameGetter) {
                try {
                    val getter = clazz.getMethod(fieldName)
                    if (getObjectType(getter.returnType).isAssignableFrom(getObjectType(fieldType))) {
                        this.getter = getter
                        break
                    }
                } catch (ex: NoSuchMethodException) {
                    // Do not need to handle
                }
            }

            if (!this.tryFieldGetter) {
                throw IllegalArgumentException("There is no public getter for " + fieldName +
                        " in " + this.clazz.name)
            }

            if (!this.field.isAccessible) {
                this.field.isAccessible = true
            }
        } while (false)
    } // init

    fun getValue(bean: T): Any? {
        val getter = this.getter
        return if (null != getter) getter.invoke(bean) else this.field.get(bean)
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is BeanFieldGetter<*>)
            false
        else
            other.clazz == this.clazz && other.field == this.field &&
                    other.trySameNameGetter == this.trySameNameGetter && other.tryFieldGetter == this.tryFieldGetter
    }

    override fun hashCode(): Int {
        return this.clazz.hashCode() + this.field.hashCode() * 31 +
                if (this.trySameNameGetter) 37 else 0 +
                if (this.tryFieldGetter) 41 else 0
    }

    override fun toString(): String {
        return "BeanFieldGetter {\"class\":\"" + this.clazz.name +
                "\",\"field\":\"" + this.field.declaringClass.name + '#' + this.field.name +
                "\",\"trySameNameGetter\":" + this.trySameNameGetter +
                "\",\"tryFieldGetter\":" + this.tryFieldGetter + '}'
    }
}