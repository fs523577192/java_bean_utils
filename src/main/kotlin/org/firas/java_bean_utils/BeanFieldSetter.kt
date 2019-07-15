package org.firas.java_bean_utils

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Set the value of a field in an object by using Java reflection API.
 *
 * This converter set the value of the field in the input bean by the
 * following:
 * 1. Find the public setter that follows the Java Bean Specification
 *    (e.g. the setter for `String userName` is
 *    `void getUserName(String userName)` and the setter for
 *    `boolean successful` is `void setSuccessful(boolean successful)`);
 * 2. If step 1 fail to find such a getter, also try to find the
 *    public getter that has the same name as the field;
 *    (e.g. `void successful(boolean value)` for `boolean successful`)
 * 4. If the above steps fail to find a setter, set the field to
 *    accessible and call `Field.set(Object, Object)`.
 *
 * @param <T> The type of the bean
 *
 * @author Wu Yuping
 */
class BeanFieldSetter<T>(
    /**
     * Allow user to specify the class because the setter may be
     * overriden in the sub-class of the class that declares the
     * field
     */
    private val clazz: Class<T>,

    /**
     * The class that declares this field must be assignable from
     * the input `clazz`
     */
    private val field: Field,

    private val trySameNameSetter: Boolean,

    private val tryFieldSetter: Boolean
) {
    constructor(clazz: Class<T>, field: Field, trySameNameGetter: Boolean):
            this(clazz, field, trySameNameGetter, true)

    constructor(clazz: Class<T>, field: Field):
            this(clazz, field, true, true)


    private var setter: Method? = null

    init {
        if (!this.field.declaringClass.isAssignableFrom(this.clazz)) {
            throw IllegalArgumentException(this.field.declaringClass.name +
                    " is not assignable from " + this.clazz.name)
        }

        val fieldName = this.field.name
        val fieldType = this.field.type
        val capitalFirst = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1)
        val setterName = "set" + capitalFirst

        do {
            var setter: Method? = null
            for (method in clazz.methods) {
                if (setterName != method.name) {
                    continue
                }
                val parameters = method.parameters
                if (1 == parameters.size && getObjectType(fieldType).isAssignableFrom(getObjectType(parameters[0].type))) {
                    setter = method
                    break
                }
            }
            if (null != setter) {
                this.setter = setter
                break
            }

            if (this.trySameNameSetter) {
                for (method in clazz.methods) {
                    if (fieldName != method.name) {
                        continue
                    }
                    val parameters = method.parameters
                    if (1 == parameters.size && getObjectType(fieldType).isAssignableFrom(getObjectType(parameters[0].type))) {
                        setter = method
                        break
                    }
                }
                if (null != setter) {
                    this.setter = setter
                    break
                }
            }

            if (!this.tryFieldSetter) {
                throw IllegalArgumentException("There is no public setter for " + fieldName +
                        " in " + this.clazz.name)
            }

            if (!this.field.isAccessible) {
                this.field.isAccessible = true
            }
        } while (false)
    } // init

    fun setValue(bean: T, value: Any?) {
        val setter = this.setter
        if (null != setter) {
            setter.invoke(bean, value)
        } else {
            field.set(bean, value)
        }
    }
}