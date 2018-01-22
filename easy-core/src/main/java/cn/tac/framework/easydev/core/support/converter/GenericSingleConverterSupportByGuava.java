package cn.tac.framework.easydev.core.support.converter;

import cn.tac.framework.easydev.core.pojo.Converter;
import org.apache.commons.collections.IteratorUtils;

import java.util.List;

/**
 * @author tac
 * @since 2.0
 */
public abstract class GenericSingleConverterSupportByGuava<FROM, TO> extends com.google.common.base.Converter<FROM, TO>
        implements Converter<FROM, TO> {
    @Override
    public List<TO> convertAll(List<FROM> from) {
        return IteratorUtils.toList(super.convertAll(from).iterator());
    }

    @Override
    @Deprecated
    protected final FROM doBackward(TO to) {
        //只支持单向转换
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final com.google.common.base.Converter reverse() {
        //只支持单向转换
        throw new UnsupportedOperationException();
    }
}
