package com.chaouki.tcshop.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

@Component
public class KafkaInitializer {

    @Autowired
    private AsyncTaskExecutor taskExecutor;

    @Autowired
    private AccountConsumer accountConsumer;

    @Autowired
    private CharacterConsumer characterConsumer;

    @Autowired
    private GearSnapshotConsumer gearSnapshotConsumer;

    @Autowired
    private GearPurchaseAckConsumer gearPurchaseAckConsumer;

    @PostConstruct
    public void init(){
        taskExecutor.submit(accountConsumer);
        taskExecutor.submit(characterConsumer);
        taskExecutor.submit(gearSnapshotConsumer);
        taskExecutor.submit(gearPurchaseAckConsumer);
    }
}
