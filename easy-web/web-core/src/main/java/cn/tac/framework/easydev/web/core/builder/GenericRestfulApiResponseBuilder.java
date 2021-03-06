package cn.tac.framework.easydev.web.core.builder;

import cn.tac.framework.easydev.web.core.pojo.RestfulApiResponse;

/**
 * @author tac
 * @since 2.0
 */
public class GenericRestfulApiResponseBuilder<T> extends RestfulApiResponseBuilderSkeleton<T, GenericRestfulApiResponseBuilder<T>> {
    private T data;
    private String stackTrace;

    void setData(T data) {
        this.data = data;
    }

    void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public GenericRestfulApiResponseBuilder(int state, String code) {
        super(state, code);
    }

    public GenericRestfulApiResponseBuilder<T> data(T data) {
        setData(data);
        return this;
    }

    public GenericRestfulApiResponseBuilder<T> stackTrack(String stackTrace) {
        setStackTrace(stackTrace);
        return this;
    }

    @Override
    public RestfulApiResponse<T> build() {
        RestfulApiResponse<T> response = super.build();
        response.setData(data);
        response.setStackTrace(stackTrace);
        return response;
    }
}
