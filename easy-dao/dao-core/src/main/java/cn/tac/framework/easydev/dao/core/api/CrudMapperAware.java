package cn.tac.framework.easydev.dao.core.api;

import cn.tac.framework.easydev.dao.core.CrudMapperSupport;
import cn.tac.framework.easydev.dao.core.pojo.MinEntityStructure;

/**
 * 感知通用crud Mapper
 *
 * @author tac
 * @since 16/11/2017
 */
public interface CrudMapperAware<E extends MinEntityStructure> {
    CrudMapperSupport<E> getMapper();
}