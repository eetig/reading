package com.eetig.reading.account.common.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Date 2022/4/22 周五 19:48
 * @Author xu
 * @FileName ThreadPoolConfit
 * @Description 线程池配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.thread-pool.common")
public class ThreadPoolConfit {
    // 核心线程数
    private int corePoolSize;
    // 最大线程数
    private int maximumPoolSize;
    //线程存活数
    private Long keepAliveTime;
    //队列容量
    private int queueCapacity;

    /**
     * @Date 2022/4/22 19:53
     * @Author eetig
     * @Description 云书架书架消费线程池
     * @param 
     * @Return
     **/
    @Bean(value = "commonQueueThreadPool")
    public ExecutorService buildCommonQueueThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("common-queue-thread-%d").build();
        //实例化
        ExecutorService pool = new ThreadPoolExecutor(this.getCorePoolSize(), this.getMaximumPoolSize(), this.getKeepAliveTime(), TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(this.getQueueCapacity()), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public Long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(Long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
