package com.cib.icarus.core.utils.id;


/**
 * 雪花算法(共计64位)
 * 固定值0(1位) + 时间戳(41位) + 数据中心id(5位)(最大值31) + 机器id(5位)(最大值31) + 毫秒内序列(12位)(最大值4095)
 * 时间戳从2020-01-01开始计算 往后3776831255551毫秒约69年
 *
 * @author goomba
 */
public class Snowflake {

    /**
     * 开始时间时间戳 2020-01-01
     */
    private final long startEpoch = 1577808000000L;

    private final long workerIdBits = 5L;

    private final long maxWorkerId = ~(-1L << workerIdBits);

    private final long dataCenterBits = 5L;

    private final long maxDataCenterId = ~(-1L << dataCenterBits);

    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;

    private final long dataCenterShift = sequenceBits + workerIdBits;

    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterBits;

    /**
     * 序列掩码，一个全为1的码值，用来做&运算，防止溢出
     */
    private final long sequenceMask = ~(-1L << sequenceBits);


    /**
     * 机器id
     */
    private final long workerId;


    /**
     * 数据中心id
     */
    private final long dataCenterId;


    /**
     * 毫秒内时间戳
     */
    private long sequence = 0L;

    /**
     * 上一次时间戳
     */
    private long lastTimeStamp = -1L;

    public Snowflake(int dataCenterId, int workerId) {
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than " + maxDataCenterId + " or less than 0");
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("workerId can't be greater than " + maxWorkerId + " or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.workerId = workerId;
    }


    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimeStamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimeStamp - timestamp));
        }

        if (lastTimeStamp == timestamp) {
            // some milliseconds in this millisecond
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimeStamp);
            }
        } else {
            sequence = 0;
        }

        lastTimeStamp = timestamp;
        return ((timestamp - startEpoch) << timestampLeftShift) |
                (dataCenterId << dataCenterShift) |
                (workerId << workerIdShift) |
                sequence;
    }


    private long tilNextMillis(long lastTimeStamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimeStamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
