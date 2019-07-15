package org.firas.java_bean_utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Wu Yuping
 */
public class BeanFieldSetterTests {
    private class Base {
        protected double double1;
        protected Double double2;

        protected double double3;
        protected Double double4;

        private double double5;
        public void setDouble5(double double5) {
            this.double5 = double5;
        }

        private Double double6;
        public void setDouble6(Double double6) {
            this.double6 = double6;
        }

        public double double7;
        public Double double8;
    }

    private class Bean extends Base {
        // ----==== Integer ====----
        private int int1;
        private Integer int2;

        protected int int3;
        protected Integer int4;

        private int int5;
        public void setInt5(int int5) {
            this.int5 = int5;
        }

        private Integer int6;
        public void setInt6(Integer int6) {
            this.int6 = int6;
        }

        public int int7;
        public Integer int8;

        private int int9;
        public void setInt9(String int9) {
            this.int9 = Integer.parseInt(int9);
        }

        private Integer int10;
        public void setInt10(String int10) {
            this.int10 = null == int10 ? null : Integer.valueOf(int10);
        }

        // ----==== Boolean ====----
        private boolean boolean1;
        private Boolean boolean2;

        protected boolean boolean3;
        protected Boolean boolean4;

        private boolean boolean5;
        public void setBoolean5(boolean boolean5) {
            this.boolean5 = boolean5;
        }

        private Boolean boolean6;
        public void setBoolean6(Boolean boolean6) {
            this.boolean6 = boolean6;
        }

        public boolean boolean7;
        public Boolean boolean8;

        // ----==== String ====----
        private String string1;
        protected String string2;

        private String string3;
        public void setString3(String string3) {
            this.string3 = string3;
        }

        public String string4;

        // ----==== Double ====----
        public void setDouble3(double double3) {
            super.double3 = double3;
        }

        public void setDouble4(Double double4) {
            super.double4 = double4;
        }
    }

    @Test
    public void test() throws Exception {
        Bean bean = new Bean();

        // ----==== Integer ====----
        int int1 = random.nextInt();
        BeanFieldSetter<Bean> int1Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int1"));
        int1Setter.setValue(bean, int1);
        BeanFieldGetter<Bean> int1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int1"));
        assertEquals(int1, int1Getter.getValue(bean));

        Integer int2 = random.randomInteger();
        BeanFieldSetter<Bean> int2Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int2"));
        int2Setter.setValue(bean, int2);
        BeanFieldGetter<Bean> int2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int2"));
        assertEquals(int2, int2Getter.getValue(bean));

        int int3 = random.nextInt();
        BeanFieldSetter<Bean> int3Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int3"));
        int3Setter.setValue(bean, int3);
        BeanFieldGetter<Bean> int3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int3"));
        assertEquals(int3, int3Getter.getValue(bean));

        Integer int4 = random.randomInteger();
        BeanFieldSetter<Bean> int4Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int4"));
        int4Setter.setValue(bean, int4);
        BeanFieldGetter<Bean> int4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int4"));
        assertEquals(int4, int4Getter.getValue(bean));

        int int5 = random.nextInt();
        BeanFieldSetter<Bean> int5Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int5"));
        int5Setter.setValue(bean, int5);
        BeanFieldGetter<Bean> int5Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int5"));
        assertEquals(int5, int5Getter.getValue(bean));

        Integer int6 = random.randomInteger();
        BeanFieldSetter<Bean> int6Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int6"));
        int6Setter.setValue(bean, int6);
        BeanFieldGetter<Bean> int6Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int6"));
        assertEquals(int6, int6Getter.getValue(bean));

        int int7 = random.nextInt();
        BeanFieldSetter<Bean> int7Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int7"));
        int7Setter.setValue(bean, int7);
        BeanFieldGetter<Bean> int7Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int7"));
        assertEquals(int7, int7Getter.getValue(bean));

        Integer int8 = random.randomInteger();
        BeanFieldSetter<Bean> int8Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int8"));
        int8Setter.setValue(bean, int8);
        BeanFieldGetter<Bean> int8Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int8"));
        assertEquals(int8, int8Getter.getValue(bean));

        int int9 = random.nextInt();
        BeanFieldSetter<Bean> int9Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int9"));
        int9Setter.setValue(bean, int9);
        BeanFieldGetter<Bean> int9Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int9"));
        assertEquals(int9, int9Getter.getValue(bean));

        Integer int10 = random.randomInteger();
        BeanFieldSetter<Bean> int10Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("int10"));
        int10Setter.setValue(bean, int10);
        BeanFieldGetter<Bean> int10Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int10"));
        assertEquals(int10, int10Getter.getValue(bean));

        // ----==== Boolean ====----
        boolean boolean1 = random.nextBoolean();
        BeanFieldSetter<Bean> boolean1Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean1"));
        boolean1Setter.setValue(bean, boolean1);
        BeanFieldGetter<Bean> boolean1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean1"));
        assertEquals(boolean1, boolean1Getter.getValue(bean));

        Boolean boolean2 = random.randomBoolean();
        BeanFieldSetter<Bean> boolean2Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean2"));
        boolean2Setter.setValue(bean, boolean2);
        BeanFieldGetter<Bean> boolean2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean2"));
        assertEquals(boolean2, boolean2Getter.getValue(bean));

        boolean boolean3 = random.nextBoolean();
        BeanFieldSetter<Bean> boolean3Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean3"));
        boolean3Setter.setValue(bean, boolean3);
        BeanFieldGetter<Bean> boolean3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean3"));
        assertEquals(boolean3, boolean3Getter.getValue(bean));

        Boolean boolean4 = random.randomBoolean();
        BeanFieldSetter<Bean> boolean4Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean4"));
        boolean4Setter.setValue(bean, boolean4);
        BeanFieldGetter<Bean> boolean4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean4"));
        assertEquals(boolean4, boolean4Getter.getValue(bean));

        boolean boolean5 = random.nextBoolean();
        BeanFieldSetter<Bean> boolean5Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean5"));
        boolean5Setter.setValue(bean, boolean5);
        BeanFieldGetter<Bean> boolean5Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean5"));
        assertEquals(boolean5, boolean5Getter.getValue(bean));

        Boolean boolean6 = random.randomBoolean();
        BeanFieldSetter<Bean> boolean6Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean6"));
        boolean6Setter.setValue(bean, boolean6);
        BeanFieldGetter<Bean> boolean6Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean6"));
        assertEquals(boolean6, boolean6Getter.getValue(bean));

        boolean boolean7 = random.nextBoolean();
        BeanFieldSetter<Bean> boolean7Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean7"));
        boolean7Setter.setValue(bean, boolean7);
        BeanFieldGetter<Bean> boolean7Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean7"));
        assertEquals(boolean7, boolean7Getter.getValue(bean));

        Boolean boolean8 = random.randomBoolean();
        BeanFieldSetter<Bean> boolean8Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("boolean8"));
        boolean8Setter.setValue(bean, boolean8);
        BeanFieldGetter<Bean> boolean8Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean8"));
        assertEquals(boolean8, boolean8Getter.getValue(bean));

        // ----==== Double ====----
        double double1 = random.nextDouble();
        BeanFieldSetter<Bean> double1Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double1"));
        double1Setter.setValue(bean, double1);
        BeanFieldGetter<Bean> double1Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double1"));
        assertEquals(double1, double1Getter.getValue(bean));

        Double double2 = random.randomDouble();
        BeanFieldSetter<Bean> double2Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double2"));
        double2Setter.setValue(bean, double2);
        BeanFieldGetter<Bean> double2Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double2"));
        assertEquals(double2, double2Getter.getValue(bean));

        double double3 = random.nextDouble();
        BeanFieldSetter<Bean> double3Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double3"));
        double3Setter.setValue(bean, double3);
        BeanFieldGetter<Bean> double3Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double3"));
        assertEquals(double3, double3Getter.getValue(bean));

        Double double4 = random.randomDouble();
        BeanFieldSetter<Bean> double4Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double4"));
        double4Setter.setValue(bean, double4);
        BeanFieldGetter<Bean> double4Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double4"));
        assertEquals(double4, double4Getter.getValue(bean));

        double double5 = random.nextDouble();
        BeanFieldSetter<Bean> double5Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double5"));
        double5Setter.setValue(bean, double5);
        BeanFieldGetter<Bean> double5Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double5"));
        assertEquals(double5, double5Getter.getValue(bean));

        Double double6 = random.randomDouble();
        BeanFieldSetter<Bean> double6Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double6"));
        double6Setter.setValue(bean, double6);
        BeanFieldGetter<Bean> double6Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double6"));
        assertEquals(double6, double6Getter.getValue(bean));

        double double7 = random.nextDouble();
        BeanFieldSetter<Bean> double7Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double7"));
        double7Setter.setValue(bean, double7);
        BeanFieldGetter<Bean> double7Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double7"));
        assertEquals(double7, double7Getter.getValue(bean));

        Double double8 = random.randomDouble();
        BeanFieldSetter<Bean> double8Setter = new BeanFieldSetter<>(Bean.class, Base.class.getDeclaredField("double8"));
        double8Setter.setValue(bean, double8);
        BeanFieldGetter<Bean> double8Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double8"));
        assertEquals(double8, double8Getter.getValue(bean));

        // ----==== String ====----
        String string1 = random.randomString();
        BeanFieldSetter<Bean> string1Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("string1"));
        string1Setter.setValue(bean, string1);
        BeanFieldGetter<Bean> string1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string1"));
        assertEquals(string1, string1Getter.getValue(bean));

        String string2 = random.randomString();
        BeanFieldSetter<Bean> string2Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("string2"));
        string2Setter.setValue(bean, string2);
        BeanFieldGetter<Bean> string2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string2"));
        assertEquals(string2, string2Getter.getValue(bean));

        String string3 = random.randomString();
        BeanFieldSetter<Bean> string3Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("string3"));
        string3Setter.setValue(bean, string3);
        BeanFieldGetter<Bean> string3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string3"));
        assertEquals(string3, string3Getter.getValue(bean));

        String string4 = random.randomString();
        BeanFieldSetter<Bean> string4Setter = new BeanFieldSetter<>(Bean.class, Bean.class.getDeclaredField("string4"));
        string4Setter.setValue(bean, string4);
        BeanFieldGetter<Bean> string4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string4"));
        assertEquals(string4, string4Getter.getValue(bean));
    }

    private RandomUtils random = new RandomUtils();
}
