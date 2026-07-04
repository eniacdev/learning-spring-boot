package com.example.cont.demo.apipath;

public final class ApiPath {

    public final static String VERSION="/v1";
    public final static String BASE="/user" + VERSION;
    public final static String GET_ALL=BASE+"/all";
    public final static String FIND_BY_ID=BASE+"/find/id/{id}";
    public final static String FIND_BY_NAME=BASE+"/find/name/{name}";
    public final static String FIND_BY_ID_GREATER_THAN=BASE+"/find/ids/{id}";
    public final static String FIND_ALL_BY_ORDER_BY_NAME=BASE+"/find/all/order-by-name";
    public final static String DELETE_BY_ID=BASE+"/delete/{id}";
    public final static String UPDATE_BY_ID=BASE+"/update/{id}";
    public final static String CREATE_USER=BASE+"/create";

}
