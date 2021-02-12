package com.shadow.extension21_import.ex;

import com.shadow.utils.PropertiesUtils;
import com.shadow.utils.YamlUtils;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
public class CustomerImportSelector implements ImportSelector, ResourceLoaderAware {

    private static final String YAML_FILE_NAME = "application.yml";
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    private static final String CONFIG_KEY = "data.decrypt.enable";

    private boolean decryptIfNecessary = false;

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] imports;
        if(decryptIfNecessary) {
            imports = new String[] {DecryptBeanPostProcessor.class.getName()};
        } else {
            imports = new String[]{};
        }
        return imports;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        String property = "";
        try {
            Resource resource = resourceLoader.getResource(YAML_FILE_NAME);
            if(!resource.exists()) {
                resource = resourceLoader.getResource(PROPERTIES_FILE_NAME);
                property = getProperty(resource, false);
            } else {
                if((property = getProperty(resource, true)) == null) {
                    resource = resourceLoader.getResource(PROPERTIES_FILE_NAME);
                    property = getProperty(resource, false);
                }
            }
            if("true".equals(property)) {
                decryptIfNecessary = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getProperty(Resource resource, boolean flag) throws Exception {
        if(flag) {
            return YamlUtils.getString(CONFIG_KEY, new Resource[]{resource});
        } else {
            return PropertiesUtils.getString(CONFIG_KEY, resource);
        }
    }
}
