package stage02;

import stage02.annotations.DataConfigure;
import stage02.configs.Config;

import java.lang.reflect.InvocationTargetException;


public class LoadConfig<T extends Config> {

    private final T config;

    public LoadConfig(Class<T> clz) {
        try {
            config = clz.getDeclaredConstructor().newInstance();
            DataConfigure annotation = clz.getAnnotation(DataConfigure.class);
            config.setPassword(annotation.password());
            config.setUsername(annotation.username());
            config.setUrl(annotation.url());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public T getConfig() {
        return config;
    }

}