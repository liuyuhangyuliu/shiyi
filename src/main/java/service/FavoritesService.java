package service;

import pojo.Article;
import pojo.Favorites;

import java.util.List;

public interface FavoritesService {
    int isFavorites(String articleID,String uid);

    void addFavorites(String articleID,String uid,String title,String imgSrc);

    void removeFavorites(String articleID,String uid);

    List<Favorites>selectMyFavorites(String uid);
}
