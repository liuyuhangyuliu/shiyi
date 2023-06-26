package service;

public interface RateService {

    float selectMyRate(String articleID,String uid);

    void updateRate(int rate,String articleID,String uid);

    int hasRate(String articleID,String uid);

    void insertRate(int rate,String articleID,String uid);
}
