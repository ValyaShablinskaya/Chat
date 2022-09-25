package by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api;

import java.util.Map;

public interface IStatisticService {
    long incSessionCount();
    long decSessionCount();
    long getSessionCount();
    Map<String, Object> getData();
}
