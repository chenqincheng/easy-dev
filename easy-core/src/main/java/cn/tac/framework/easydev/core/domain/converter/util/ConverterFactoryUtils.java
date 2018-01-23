package cn.tac.framework.easydev.core.domain.converter.util;

import cn.tac.framework.easydev.core.domain.converter.Converter;
import cn.tac.framework.easydev.core.domain.converter.annotation.Register2Factory;

/**
 * @author tac
 * @since 2.0
 */
public abstract class ConverterFactoryUtils {
    public static boolean isConverterCandidate(Object obj) {
        Register2Factory annotation = getRegisterAnnotation(obj);
        return annotation != null && annotation.register() && obj instanceof Converter;
    }

    public static Register2Factory getRegisterAnnotation(Object obj) {
        return obj.getClass().getAnnotation(Register2Factory.class);
    }
}