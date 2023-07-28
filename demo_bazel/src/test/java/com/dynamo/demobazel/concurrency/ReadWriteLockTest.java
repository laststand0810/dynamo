package com.dynamo.demobazel.concurrency;

import java.time.Clock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Before;
import org.junit.Test;

public class ReadWriteLockTest {

  ExecutorService executors = Executors.newScheduledThreadPool(4);
  ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  Clock clock = Clock.systemDefaultZone();

  Map<String, String> dataTest = new ConcurrentHashMap<>();

  @Before
  public void setup() {
    dataTest.clear();
    dataTest.put("keyA", "dataA");
    dataTest.put("keyB", "dataA");
  }

  public static void sleep(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

  class Reader implements Runnable {

    Long seriesNo;

    Reader(Long seriesNo) {
      this.seriesNo = seriesNo;
    }

    @Override
    public void run() {
      int[] nums = {1, 2, 3, 4, 5};
      for (int i : nums) {
        if (lock.readLock().tryLock()) {
          System.out.printf("%d - Reader No. %d is reading\n", clock.millis(), seriesNo);

          lock.readLock().unlock();

        } else {
          sleep(2);
          System.out.printf("%d - Reader No. %d failed to read %d times\n", clock.millis(),
              seriesNo, i);
        }
      }

    }
  }

  class Writer implements Runnable {

    Long seriesNo;

    Writer(Long seriesNo) {
      this.seriesNo = seriesNo;
    }

    @Override
    public void run() {
      if (lock.writeLock().tryLock()) {
        System.out.printf("%d - Writer No. %d is writing\n", clock.millis(), seriesNo);
        try {
          sleep(2);
          System.out.printf("%d - Writer No. %d has finished writing\n", clock.millis(), seriesNo);
        } finally {
          lock.writeLock().unlock();
        }
      } else {
        System.out.printf("%d - Writer No. %d failed to write\n", clock.millis(), seriesNo);
      }
    }
  }


  @Test
  public void testWriteLockingWhenReadLocked() {
    Reader reader1 = new Reader(1L);
    Reader reader2 = new Reader(2L);

    Writer writer1 = new Writer(1L);

    executors.submit(writer1);
    executors.submit(reader1, 3);
    executors.submit(reader2, 3);

    // read locks and write locks are locking the other side respectively, read lock locks write access and vice versa

    sleep(5);


  }

}
