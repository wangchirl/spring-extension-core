package com.shadow.extension25_autoconfig.ex.support;

import com.shadow.extension21_import.ex.DecryptBeanPostProcessor;
import com.shadow.extension25_autoconfig.ex.aop.DynamicDatasourceAspect;
import com.shadow.utils.PropertiesUtils;
import com.shadow.utils.YamlUtils;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shadow
 * @create 2021-02-13
 * @description
 */
public class DynamicDatasourceImportSelector implements ImportSelector , ResourceLoaderAware {

    private static final String YAML_FILE_NAME = "application.yml";
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    private static final String CONFIG_KEY = "enable.default.datasource.decrypt";

    private boolean enableDecrypt = false;

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
                enableDecrypt = true;
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

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] imports;
        if(enableDecrypt) {
            imports = new String[] {DynamicDatasourceAspect.class.getName(), DecryptBeanPostProcessor.class.getName()};
        } else {
            imports = new String[]{DynamicDatasourceAspect.class.getName()};
        }
        return imports;
    }
}
