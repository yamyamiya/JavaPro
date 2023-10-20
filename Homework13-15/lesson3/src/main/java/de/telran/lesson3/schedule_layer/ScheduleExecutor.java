package de.telran.lesson3.schedule_layer;

import de.telran.lesson3.domain_layer.entity.jpa.Task;
import de.telran.lesson3.repository_layer.jpa.JpaProductRepository;
import de.telran.lesson3.repository_layer.jpa.JpaTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@EnableScheduling
@EnableAsync //-для многопоточности
public class ScheduleExecutor {
    @Autowired
    private JpaTaskRepository repository;

    @Autowired
    private JpaProductRepository productRepository;
    private static Logger logger = LoggerFactory.getLogger(ScheduleExecutor.class);

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("Fixed Delay task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("Fixed Delay task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        Task task = new Task("Fixed Delay task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        Task task = new Task("Fixed rate task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        Task task = new Task("Fixed rate task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    @Async
//    public void fixedRateTask() {
//        Task task = new Task("Fixed rate task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    @Scheduled(fixedRate = 5000, initialDelay = 15000)
//    @Async
//    public void initialDelayTask() {
//        Task task = new Task("Initial delay task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


    // fixedDelay = 7200000 - два часа
    // fixedDelayString = "PT02H" - два часа
//    @Scheduled(fixedDelayString = "PT07S")
//    public void anotherDelayFormatTask() {
//        Task task = new Task("Another delay format task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    @Scheduled(fixedDelayString = "${interval}")
//    public void delayInPropertyTask() {
//        Task task = new Task("Delay in property task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // 55 * * * * * - задача будет выполняться в 55 секунд каждой минуты
    // 0 15 9-17 * * MON-FRI - задача будет выполняться в 15 минут каждого часа с 9 до 17,
    // только по рабочим дням
    // 0 0 * * * * -> @hourly
//    @Scheduled(cron= "${cron-interval}")
//    public void cronExpressionTask() {
//        Task task = new Task("cron Expression task.");
//        logger.info(task.getDescription());
//        repository.save(task);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public static void taskSchedulerTaskWithTrigger(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        scheduler.schedule(() -> logger.info(task.getDescription()),
                new CronTrigger("0,10,20,30,40,50 * * * * *"));
    }

    public static void taskSchedulerTaskWithInstant(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        Instant instant = Instant.now().plusSeconds(20);
        scheduler.schedule(() -> logger.info(task.getDescription()), instant);

    }


//    1. Реализовать вывод в консоль каждые 30 секунд списка последних пяти выполненных задач.
//   Время выполнения предыдущей задачи не должно влиять на старт следующей.

    @Scheduled(fixedRate = 30000)
    @Async
    public void lastFiveTasks(){
        List<Task> taskList = repository.lastFiveTasks();
        for (int i = 0; i <taskList.size(); i++) {
            System.out.println(taskList.get(i));
        }
    }

//2. Реализовать вывод в консоль последнего добавленного в БД товара.
//   Вывод должен производиться в 15 и 45 секунд каждой минуты.
//   Задача должна быть сохранена в БД.

    @Scheduled(cron= "15,45 * * * * *")
    public void cronExpressionTask() {

        Task task = new Task("Last added product is " + productRepository.getLastAddedProduct().getName());
        logger.info(task.getDescription());
        repository.save(task);
    }



//3. После запроса конкретного продукта через 15 секунд отправить персональное предложение
//   на этот продукт с ценой на 5-10% (рандомно) ниже, чем базовая цена.
//   Имитировать отправку в виде вывода в консоль и логирования.
//   Данная задача должна выполняться при помощи АОП и сохраняться в БД.



    public void taskSchedulerForCertainProduct(Task task) {
        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
        Instant instant = Instant.now().plusSeconds(15);
        scheduler.schedule(() -> {logger.info(task.getDescription());
            System.out.println(task.getDescription());}, instant);
        repository.save(task);
    }


//4. После того как покупатель очистил корзину, через 20 секунд выбрать из корзины случайный товар,
//   который там был, сделать на него скидку 15% и предложить покупателю всё-таки
//   приобрести все эти товары, вывести все товары (один с новой ценой), а также старую и новую стоимость корзины.
//   Данная задача должна выполняться при помощи АОП и сохраняться в БД.
//Вывод в консоль должен быть осуществлён через логирование поля description созданной задачи.
//    Поле description задачи должно содержать предложение приобрести все товары из корзины,
//    список товаров из корзины (каждый товар с новой строки), причём товар со скидкой должен быть указан с новой ценой,
//    а также с новой строки - старую стоимость корзины и новую стоимость корзины.
//    Указание скидки для данного предложения не должно влиять на базовую цену товара в БД.
public static void taskSchedulerForClearCart(Task task) {
    TaskScheduler scheduler = new DefaultManagedTaskScheduler();
    Instant instant = Instant.now().plusSeconds(20);
    scheduler.schedule(() -> {logger.info(task.getDescription());
        System.out.println(task.getDescription());}, instant);
}




}
