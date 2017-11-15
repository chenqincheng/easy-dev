package cn.tac.framework.easydev.dao.core.util;

import cn.tac.framework.easydev.dao.core.bean.RuntimeData4Dao;
import cn.tac.framework.easydev.dao.core.pojo.GenericBusinessUUIDEntity;
import cn.tac.framework.easydev.dao.core.strategy.deletedflag.IntegerDeletedFlagMapping;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tac
 * @since 16/11/2017
 */
public class EntityUtilsTest {
    public static final String ORG_ID = "taccisum";
    public static final String USER_ID = "tac";

    @Before
    public void setUp() throws Exception {
        new EntityUtils().setRuntimeData4Dao(new RuntimeData4Dao() {
            @Override
            public String userId() {
                return USER_ID;
            }

            @Override
            public String organizationId() {
                return ORG_ID;
            }
        });
    }

    @Test
    public void init() throws Exception {
        FooEntity entity = new FooEntity();
        EntityUtils.init(entity);
        assertThat(entity.getId()).isNotBlank();
        assertThat(entity.getCreatedBy()).isEqualTo(USER_ID);
        assertThat(entity.getCreatedOn()).isNotNull();
        assertThat(entity.getUpdatedBy()).isNull();
        assertThat(entity.getUpdatedOn()).isNull();
        assertThat(entity.getDeletedFlag()).isEqualTo(IntegerDeletedFlagMapping.instance().getEnableFlag());
        assertThat(entity.getOrganizationId()).isEqualTo(ORG_ID);
        assertThat(entity.getBar1()).isEqualTo(FooEntity.BAR1_DEFAULT);
    }

    static class FooEntity extends GenericBusinessUUIDEntity {
        public static final String BAR1_DEFAULT = "bar1";
        private String bar1;

        public String getBar1() {
            return bar1;
        }

        public void setBar1(String bar1) {
            this.bar1 = bar1;
        }

        @Override
        public void initDefaultValue() {
            bar1 = BAR1_DEFAULT;
        }
    }
}
