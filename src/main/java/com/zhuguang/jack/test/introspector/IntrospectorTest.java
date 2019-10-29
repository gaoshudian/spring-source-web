package com.zhuguang.jack.test.introspector;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
JAVA内省机制的理解:

Java中的反射机制是通过名称得到类的方法和对象的成份，对于一切Java类都是适用的，但是有时候使用起来比较麻烦。
而JavaBean是一种特殊的Java类，遵守JavaBean的规范，即所有的成员都是私有成员，且每个成员都有公开的读取和
设定的方法（getter和setter），且这些方法都遵守命名的规范。就是因为JavaBean有这些的特性，sun推出了一种
专门对JavaBean成员进行访问的技术，方便对其的访问，就是内省技术。

Java中的反射机制是通过名称得到类的方法和对象的成份。

内省技术，专门对JavaBean成员进行访问的技术。也是用来获取类的方法和对象的成份。（JavaBean是一种特殊的Java类）


java api中内省机制有两种使用方式
1.通过PropertyDescriptor类
2.通过类Introspector的getBeanInfo()方法获取某个对象的BeanInfo信息，然后通过BeanInfo来获取属性的描述器(PropertyDescriptor),
通过这个属性描述器就可以获取某个属性对应的 getter/setter方法,然后我们就可以通过反射机制来调用这些方法
 */
public class IntrospectorTest {

    @Test
    public void test() throws Exception {

        MyBean myBean = new MyBean();
        PropertyDescriptor pd = new PropertyDescriptor("name", myBean.getClass());
        Method writeMethod = pd.getWriteMethod();
        writeMethod.invoke(myBean, "小高");

        Method readMethod = pd.getReadMethod();
        System.out.println(readMethod.invoke(myBean));

    }

    //实际项目中可将此方法写成工具类，接收一个map,一次性给对象所有属性赋值
    @Test
    public void test2() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "小高");
        map.put("sex", "男");

        MyBean myBean = new MyBean();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String propertyName = entry.getKey();
            Object propertyValue = entry.getValue();
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, myBean.getClass());
            Method method = pd.getWriteMethod();
            method.invoke(myBean, propertyValue);

            Method readMethod = pd.getReadMethod();
            System.out.println(readMethod.invoke(myBean));

        }

        PropertyDescriptor pd1 = new PropertyDescriptor("name", myBean.getClass());
        Method readMethod1 = pd1.getReadMethod();
        System.out.println(readMethod1.invoke(myBean));

        PropertyDescriptor pd2 = new PropertyDescriptor("sex", myBean.getClass());
        Method readMethod2 = pd2.getReadMethod();
        System.out.println(readMethod2.invoke(myBean));


    }

    @Test
    public void test3() throws Exception{
        BeanInfo beanInfo = Introspector.getBeanInfo(MyBean.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if(writeMethod != null){
                System.out.println("writerMethod : " + writeMethod.getName());

                Method readMethod = propertyDescriptor.getReadMethod();
                String readmethodName = readMethod.getName();
                System.out.println("readMethod : " + readmethodName);
            }
        }
    }
}