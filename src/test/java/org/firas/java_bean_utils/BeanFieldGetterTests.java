package org.firas.java_bean_utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Wu Yuping
 */
public class BeanFieldGetterTests {

    private static class Base {
        Base(double double1, Double double2, double double3, Double double4, double double5, Double double6) {
            this.double1 = double1;
            this.double2 = double2;

            this.double3 = double3;
            this.double4 = double4;

            this.double5 = double5;
            this.double6 = double6;
        }

        protected double double1;
        protected Double double2;

        protected double double3;
        protected Double double4;

        private double double5;
        public double getDouble5() {
            return double5;
        }

        private Double double6;
        public Double getDouble6() {
            return double6;
        }

        public double double7;
        public Double double8;
    }

    private static class Bean extends Base {
        Bean(
            int int1, Integer int2, int int3, Integer int4,
                    int int5, Integer int6, int int9, Integer int10,
            boolean boolean1, Boolean boolean2, boolean boolean3, Boolean boolean4,
                    boolean boolean5, Boolean boolean6, boolean boolean9, Boolean boolean10,
            String string1, String string2, String string3,
            double double1, Double double2, double double3, Double double4, double double5, Double double6
        ) {
            super(double1, double2, double3, double4, double5, double6);

            this.int1 = int1;
            this.int2 = int2;
            this.int3 = int3;
            this.int4 = int4;
            this.int5 = int5;
            this.int6 = int6;
            this.int9 = int9;
            this.int10 = int10;

            this.boolean1 = boolean1;
            this.boolean2 = boolean2;
            this.boolean3 = boolean3;
            this.boolean4 = boolean4;
            this.boolean5 = boolean5;
            this.boolean6 = boolean6;
            this.boolean9 = boolean9;
            this.boolean10 = boolean10;

            this.string1 = string1;
            this.string2 = string2;
            this.string3 = string3;
        }

        // ----==== Integer ====----
        private int int1;
        private Integer int2;

        protected int int3;
        protected Integer int4;

        private int int5;
        public int getInt5() {
            return this.int5;
        }

        private Integer int6;
        public Integer getInt6() {
            return this.int6;
        }

        public int int7;
        public Integer int8;

        private int int9;
        public String getInt9() {
            return String.valueOf(int9);
        }

        private Integer int10;
        public String getInt10() {
            return String.valueOf(int10);
        }

        // ----==== Boolean ====----
        private boolean boolean1;
        private Boolean boolean2;

        protected boolean boolean3;
        protected Boolean boolean4;

        private boolean boolean5;
        public boolean getBoolean5() {
            return this.boolean5;
        }

        private Boolean boolean6;
        public Boolean getBoolean6() {
            return this.boolean6;
        }

        public boolean boolean7;
        public Boolean boolean8;

        private boolean boolean9;
        public boolean isBoolean9() {
            return this.boolean9;
        }

        private Boolean boolean10;
        public Boolean isBoolean10() {
            return this.boolean10;
        }

        // ----==== String ====----
        private String string1;
        protected String string2;

        private String string3;
        public String getString3() {
            return this.string3;
        }

        public String string4;

        // ----==== Double ====----
        public double getDouble3() {
            return super.double3;
        }

        public Double getDouble4() {
            return super.double4;
        }
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i += 1) {
            int int1 = random.nextInt();
            Integer int2 = random.randomInteger();
            int int3 = random.nextInt();
            Integer int4 = random.randomInteger();
            int int5 = random.nextInt();
            Integer int6 = random.randomInteger();
            int int7 = random.nextInt();
            Integer int8 = random.randomInteger();
            int int9 = random.nextInt();
            Integer int10 = random.randomInteger();

            boolean boolean1 = random.nextBoolean();
            Boolean boolean2 = random.randomBoolean();
            boolean boolean3 = random.nextBoolean();
            Boolean boolean4 = random.randomBoolean();
            boolean boolean5 = random.nextBoolean();
            Boolean boolean6 = random.randomBoolean();
            boolean boolean7 = random.nextBoolean();
            Boolean boolean8 = random.randomBoolean();
            boolean boolean9 = random.nextBoolean();
            Boolean boolean10 = random.randomBoolean();

            double double1 = random.nextDouble();
            Double double2 = random.randomDouble();
            double double3 = random.nextDouble();
            Double double4 = random.randomDouble();
            double double5 = random.nextDouble();
            Double double6 = random.randomDouble();
            double double7 = random.nextDouble();
            Double double8 = random.randomDouble();

            String string1 = random.randomString();
            String string2 = random.randomString();
            String string3 = random.randomString();
            String string4 = random.randomString();

            Bean bean = new Bean(int1, int2, int3, int4, int5, int6, int9, int10,
                    boolean1, boolean2, boolean3, boolean4, boolean5, boolean6, boolean9, boolean10,
                    string1, string2, string3,
                    double1, double2, double3, double4, double5, double6);
            bean.int7 = int7;
            bean.int8 = int8;
            bean.boolean7 = boolean7;
            bean.boolean8 = boolean8;
            bean.string4 = string4;
            bean.double7 = double7;
            bean.double8 = double8;

            BeanFieldGetter<Bean> int1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int1"));
            assertEquals(int1, int1Getter.getValue(bean));
            BeanFieldGetter<Bean> int2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int2"));
            assertEquals(int2, int2Getter.getValue(bean));
            BeanFieldGetter<Bean> int3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int3"));
            assertEquals(int3, int3Getter.getValue(bean));
            BeanFieldGetter<Bean> int4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int4"));
            assertEquals(int4, int4Getter.getValue(bean));
            BeanFieldGetter<Bean> int5Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int5"));
            assertEquals(int5, int5Getter.getValue(bean));
            BeanFieldGetter<Bean> int6Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int6"));
            assertEquals(int6, int6Getter.getValue(bean));
            BeanFieldGetter<Bean> int7Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int7"));
            assertEquals(int7, int7Getter.getValue(bean));
            BeanFieldGetter<Bean> int8Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int8"));
            assertEquals(int8, int8Getter.getValue(bean));
            BeanFieldGetter<Bean> int9Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int9"));
            assertEquals(int9, int9Getter.getValue(bean));
            BeanFieldGetter<Bean> int10Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("int10"));
            assertEquals(int10, int10Getter.getValue(bean));

            BeanFieldGetter<Bean> boolean1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean1"));
            assertEquals(boolean1, boolean1Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean2"));
            assertEquals(boolean2, boolean2Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean3"));
            assertEquals(boolean3, boolean3Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean4"));
            assertEquals(boolean4, boolean4Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean5Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean5"));
            assertEquals(boolean5, boolean5Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean6Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean6"));
            assertEquals(boolean6, boolean6Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean7Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean7"));
            assertEquals(boolean7, boolean7Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean8Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean8"));
            assertEquals(boolean8, boolean8Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean9Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean9"));
            assertEquals(boolean9, boolean9Getter.getValue(bean));
            BeanFieldGetter<Bean> boolean10Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("boolean10"));
            assertEquals(boolean10, boolean10Getter.getValue(bean));

            BeanFieldGetter<Bean> double1Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double1"));
            assertEquals(double1, double1Getter.getValue(bean));
            BeanFieldGetter<Bean> double2Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double2"));
            assertEquals(double2, double2Getter.getValue(bean));
            BeanFieldGetter<Bean> double3Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double3"));
            assertEquals(double3, double3Getter.getValue(bean));
            BeanFieldGetter<Bean> double4Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double4"));
            assertEquals(double4, double4Getter.getValue(bean));
            BeanFieldGetter<Bean> double5Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double5"));
            assertEquals(double5, double5Getter.getValue(bean));
            BeanFieldGetter<Bean> double6Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double6"));
            assertEquals(double6, double6Getter.getValue(bean));
            BeanFieldGetter<Bean> double7Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double7"));
            assertEquals(double7, double7Getter.getValue(bean));
            BeanFieldGetter<Bean> double8Getter = new BeanFieldGetter<>(Bean.class, Base.class.getDeclaredField("double8"));
            assertEquals(double8, double8Getter.getValue(bean));

            BeanFieldGetter<Bean> string1Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string1"));
            assertEquals(string1, string1Getter.getValue(bean));
            BeanFieldGetter<Bean> string2Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string2"));
            assertEquals(string2, string2Getter.getValue(bean));
            BeanFieldGetter<Bean> string3Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string3"));
            assertEquals(string3, string3Getter.getValue(bean));
            BeanFieldGetter<Bean> string4Getter = new BeanFieldGetter<>(Bean.class, Bean.class.getDeclaredField("string4"));
            assertEquals(string4, string4Getter.getValue(bean));
        }
    }

    private RandomUtils random = new RandomUtils();
}