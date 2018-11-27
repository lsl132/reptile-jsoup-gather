package org.plat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledService {

    private static Logger logger = LoggerFactory.getLogger(ScheduledService.class);



    @Scheduled(cron = "0/5 * * * * *")
    public void reptileweb() {
        logger.warn("=====>>>>>使用reptileweb  {}",System.currentTimeMillis());
    }


}
