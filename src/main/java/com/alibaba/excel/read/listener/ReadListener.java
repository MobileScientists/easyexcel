package com.alibaba.excel.read.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.Listener;

/**
 * Interface to listen for read results
 * 
 * @author zhuangjiaju
 */
public interface ReadListener<T> extends Listener {
    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     * 
     * @param exception
     * @param context
     * @throws Exception
     */
    void onException(Exception exception, AnalysisContext context) throws Exception;

    /**
     * when analysis one row trigger invoke function.
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#currentRowAnalysisResult()}
     * @param context
     *            analysis context
     */
    void invoke(T data, AnalysisContext context);

    /**
     * if have something to do after all analysis
     *
     * @param context
     */
    void doAfterAllAnalysed(AnalysisContext context);

    /**
     * Verify that there is another piece of data.You can stop the read by returning false
     *
     * @param context
     * @return
     */
    boolean hasNext(AnalysisContext context);
}
