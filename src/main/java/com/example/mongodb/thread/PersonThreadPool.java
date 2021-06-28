package com.example.mongodb.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * @author ken
 * @className PersonThreadPool
 * @description 构造人员线程池
 * @date 2021/6/25 5:04 下午
 **/
@Configuration
public class PersonThreadPool {


    private static final int CORE_POOL_SIZE = 10;
    private static final String THREAD_NAME = "person_thread";
    private static final int MAXI_NUM_SIZE = 20;
    private static final int KEEP_ALIVE_TIME = 30;
    private static final int LINK_BLOCK_QUEUE_SIZE = 1000;


    private LinkedBlockingQueue personLinkedQueue;

    @Bean
    public ExecutorService personExecutor(){
        personLinkedQueue = new LinkedBlockingQueue<Runnable>(LINK_BLOCK_QUEUE_SIZE);
        ThreadFactory factory = new CustomizableThreadFactory(THREAD_NAME);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXI_NUM_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                personLinkedQueue,
                factory,
                new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }


}