package com.zhuguang.jack.test;

import org.junit.Test;
import org.springframework.core.io.*;

/**
 * 名称: ResourceLoaderTest.java
 * 描述: spring统一资源加载测试,细节相关可参考http://cmsblogs.com/?p=2656
 *
 * @author gaoshudian
 * @date 2019/8/13 2:30 PM
 */
public class ResourceLoaderTest {

    @Test
    public void resourceLoaderTest() throws Exception {

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        //换成一下代码时fileResource1类型为FileSystemResource
//        ResourceLoader resourceLoader = new FileSystemResourceLoader();

        Resource fileResource1 = resourceLoader.getResource("config/spring/applicationContext-core.xml");
        System.out.println("fileResource1 is FileSystemResource:" + (fileResource1 instanceof FileSystemResource));

        Resource fileResource2 = resourceLoader.getResource("classpath:config/spring/applicationContext-core.xml");
        System.out.println("fileResource2 is ClassPathResource:" + (fileResource2 instanceof ClassPathResource));
        System.out.println(fileResource2.getInputStream());

        Resource urlResource1 = resourceLoader.getResource("file:/Users/chenming673/Documents/spark.txt");
        System.out.println("urlResource1 is UrlResource:" + (urlResource1 instanceof UrlResource));

        Resource urlResource2 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println("urlResource1 is urlResource:" + (urlResource2 instanceof UrlResource));
        System.out.println(urlResource2.getInputStream());
    }
}
