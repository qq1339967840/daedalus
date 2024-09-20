package com.cib.icarus.spi;

public interface Ordered {

    Integer HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

    Integer LOWEST_PRECEDENCE = Integer.MAX_VALUE;
    
    int getOrder();

}
