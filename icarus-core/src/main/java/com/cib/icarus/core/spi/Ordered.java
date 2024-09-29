package com.cib.icarus.core.spi;

/**
 * @author goomba
 */
public interface Ordered {

    /**
     * 最高优先级
     */
    int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

    /**
     * 最低优先级
     */
    int LOWEST_PRECEDENCE = Integer.MAX_VALUE;


    int getOrder();

}
