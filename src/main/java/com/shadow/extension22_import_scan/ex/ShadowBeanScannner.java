package com.shadow.extension22_import_scan.ex;

import com.shadow.extension22_import_scan.ex.annotation.Shadow;
import com.sun.corba.se.impl.presentation.rmi.IDLTypeException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class ShadowBeanScannner {

    /**
     * packages
     */
    private Set<String> packageToScan;

    /**
     * class path
     */
    private List<String> classPaths = new ArrayList<>();

    /**
     * class
     */
    private List<Class<?>> classes = new ArrayList<>();

    public ShadowBeanScannner(Set<String> packageToScan) {
        this.packageToScan = packageToScan;
    }

    public List<BeanDefinitionHolder> scan() {
        try {
            // do scan
            doScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // candidate and return
        return candidateClass(classes);
    }

    /**
     * 推断何时的 class 类
     * @see com.shadow.extension22_import_scan.ex.annotation.Shadow
     * @param classes
     * @return
     */
    private List<BeanDefinitionHolder> candidateClass(List<Class<?>> classes) {
        return classes.stream().filter(item -> item.isAnnotationPresent(Shadow.class)).map(item -> {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(item);
            return new BeanDefinitionHolder(beanDefinitionBuilder.getBeanDefinition(), item.getSimpleName());
        }).collect(Collectors.toList());
    }

    private void doScan() throws ClassNotFoundException {
        for (String path : packageToScan) {
            // absolute path
            String basePath = this.getClass().getResource("/").getPath().replace("/", File.separator);
            // . -> /
            path = path.replace(".", File.separator);
            doPath(new File(basePath + path));
            for (String classPath : classPaths) {
                // class name string eg: com.shadow..xxxEntity
                classPath = classPath.replace(basePath.replace("/","\\")
                                    .replaceFirst("\\\\",""),"")
                                    .replace("\\",".").replace(".class","");
                Class<?> aClass = Class.forName(classPath);
                classes.add(aClass);
            }
        }

    }

    private void doPath(File file) {
        if(file.isDirectory()) { // dictionary
            File[] files = file.listFiles();
            for (File f : files) {
                doPath(f);
            }
        }else {
            if(file.getName().endsWith(".class")) {
                classPaths.add(file.getPath());
            }
        }
    }
}
