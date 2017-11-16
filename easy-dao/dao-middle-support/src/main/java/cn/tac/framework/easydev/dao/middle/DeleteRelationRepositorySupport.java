package cn.tac.framework.easydev.dao.middle;

import cn.tac.framework.easydev.dao.core.api.EntityClassAware;
import cn.tac.framework.easydev.dao.middle.pojo.GenericMiddleEntity;

/**
 * @author tac
 * @since 17/11/2017
 */
public interface DeleteRelationRepositorySupport<E extends GenericMiddleEntity<PK, LPK, RPK>, PK, LPK, RPK>
        extends EntityClassAware<E> {
    int unrelate(LPK sourceId, RPK... targetIds);

    int unrelateAll(LPK sourceId);
}